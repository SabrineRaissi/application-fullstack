package com.example.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class HuggingFaceService {
    
    @Value("${huggingface.api.token}")
    private String apiToken;
    
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String apiUrl = "https://api-inference.huggingface.co/models/google/flan-t5-base";
    
    public HuggingFaceService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }
    
    public String generateResponse(String prompt) {
        try {
            // Préparer les headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiToken);
            
            // Préparer le body
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("inputs", prompt);
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("max_length", 150);
            parameters.put("temperature", 0.7);
            requestBody.put("parameters", parameters);
            
            // Créer la requête
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);
            
            // Envoyer la requête
            ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                request,
                String.class
            );
            
            // Parser la réponse
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                JsonNode jsonResponse = objectMapper.readTree(response.getBody());
                
                // La réponse est un tableau
                if (jsonResponse.isArray() && jsonResponse.size() > 0) {
                    String generatedText = jsonResponse.get(0).get("generated_text").asText();
                    return generatedText;
                }
            }
            
            return "Désolé, je n'ai pas pu générer de réponse.";
            
        } catch (Exception e) {
            System.err.println("Erreur Hugging Face API: " + e.getMessage());
            e.printStackTrace();
            
            // Message d'erreur plus explicite
            if (e.getMessage().contains("401")) {
                return "Erreur d'authentification. Vérifiez votre token Hugging Face.";
            } else if (e.getMessage().contains("503")) {
                return "Le modèle est en cours de chargement. Réessayez dans quelques secondes.";
            }
            
            return "Erreur lors de la communication avec l'IA: " + e.getMessage();
        }
    }
}