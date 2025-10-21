package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatbotService {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private HuggingFaceService huggingFaceService;
    
    public String chat(String userMessage) {
        // Récupérer les données des utilisateurs
        List<User> users = userService.getAllUsers();
        
        // Analyse simple pour répondre directement (plus rapide)
        String lowerMessage = userMessage.toLowerCase();
        
        // Réponses directes pour les questions simples
        if (lowerMessage.contains("combien") && lowerMessage.contains("utilisateur")) {
            return "Il y a actuellement " + users.size() + " utilisateur(s) dans la base de données.";
        }
        
        if (lowerMessage.contains("liste") || lowerMessage.contains("tous")) {
            if (users.isEmpty()) {
                return "Il n'y a aucun utilisateur dans la base de données.";
            }
            
            StringBuilder response = new StringBuilder("Voici la liste des utilisateurs:\n\n");
            for (User user : users) {
                response.append("• ").append(user.getNom())
                        .append(" (").append(user.getAge()).append(" ans) - ")
                        .append(user.getEmail()).append("\n");
            }
            return response.toString();
        }
        
        if (lowerMessage.contains("âgé") || lowerMessage.contains("age")) {
            if (users.isEmpty()) {
                return "Il n'y a aucun utilisateur dans la base de données.";
            }
            
            User oldest = users.stream()
                    .max((u1, u2) -> u1.getAge().compareTo(u2.getAge()))
                    .orElse(null);
            
            if (oldest != null) {
                return "L'utilisateur le plus âgé est " + oldest.getNom() + 
                       " avec " + oldest.getAge() + " ans.";
            }
        }
        
        if (lowerMessage.contains("jeune")) {
            if (users.isEmpty()) {
                return "Il n'y a aucun utilisateur dans la base de données.";
            }
            
            User youngest = users.stream()
                    .min((u1, u2) -> u1.getAge().compareTo(u2.getAge()))
                    .orElse(null);
            
            if (youngest != null) {
                return "L'utilisateur le plus jeune est " + youngest.getNom() + 
                       " avec " + youngest.getAge() + " ans.";
            }
        }
        
        // Pour les questions complexes, utiliser l'IA
        String context = buildContext(users, userMessage);
        return huggingFaceService.generateResponse(context);
    }
    
    private String buildContext(List<User> users, String question) {
        StringBuilder context = new StringBuilder();
        context.append("Contexte: Base de données avec ").append(users.size()).append(" utilisateurs.\n");
        
        if (!users.isEmpty() && users.size() <= 10) {
            context.append("Utilisateurs: ");
            context.append(users.stream()
                .map(u -> u.getNom() + " (" + u.getAge() + " ans)")
                .collect(Collectors.joining(", ")));
            context.append(".\n");
        }
        
        context.append("\nQuestion: ").append(question);
        context.append("\nRéponse courte en français:");
        
        return context.toString();
    }
}