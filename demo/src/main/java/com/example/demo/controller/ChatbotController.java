package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ChatRequest;
import com.example.demo.entity.ChatResponse;
import com.example.demo.service.ChatbotService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/chatbot")

@SecurityRequirement(name = "bearerAuth") 
public class ChatbotController {
    @Autowired
    private ChatbotService chatbotService;
    
    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String response = chatbotService.chat(request.getMessage());
        return new ChatResponse(response);
    }
}
