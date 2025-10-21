import { Component } from '@angular/core';
import { ChatbotService } from '../../services/chatbot.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
interface Message {
  text: string;
  isUser: boolean;
  timestamp: Date;
}
@Component({
  selector: 'app-chatbot',
  imports: [CommonModule, FormsModule],
  templateUrl: './chatbot.html',
  styleUrl: './chatbot.css'
})
export class Chatbot {
   messages: Message[] = [];
  userInput = '';
  isLoading = false;
  constructor(private chatbotService : ChatbotService) {
       // Message de bienvenue
    this.messages.push({
      text: "Bonjour ! Je suis votre assistant IA. Posez-moi des questions sur les utilisateurs de la base de données !",
      isUser: false,
      timestamp: new Date()
    });
  }
  sendMessage() {
    if (!this.userInput.trim() || this.isLoading) {
      return;
    }
    this.messages.push({
      text: this.userInput,
      isUser: true,
      timestamp: new Date()
    });
   const question = this.userInput;
    this.userInput = '';
    this.isLoading = true;
    this.chatbotService.sendMessage(question).subscribe({
      next: (response) => {this.messages.push({
        text: response.response,
        isUser: false,
        timestamp: new Date()
      });
      this.isLoading = false;
      this.scrollToBottom();
    }, error: (err) => {
      this.messages.push({
        text: "Désolé, une erreur s'est produite. Veuillez réessayer plus tard.",
        isUser: false,
        timestamp: new Date()
      });
      this.isLoading = false;
     console.error('Erreur lors de la communication avec le chatbot :', err);
    }});
    }
  scrollToBottom() {
    setTimeout(() => {
      const chatContainer = document.getElementById('chat-messages');
      if (chatContainer) {
        chatContainer.scrollTop = chatContainer.scrollHeight;
      }
    }, 100);
  }
   handleKeyPress(event: KeyboardEvent) {
    if (event.key === 'Enter' && !event.shiftKey) {
      event.preventDefault();
      this.sendMessage();
    }
  }
}
