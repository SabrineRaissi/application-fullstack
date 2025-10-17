package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/users/")
@SecurityRequirement(name = "bearerAuth") 
public class DemoController {
    @Autowired
    private UserService userService;
    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping()
    public User creatUser(@RequestBody User user) {
        
        return userService.createUser(user);
    }
    @PutMapping("update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        
        return userService.updateUser(id, user);
    }

    @DeleteMapping("delete/{id}")
     @PreAuthorize("hasRole('ADMIN')")  // Seul l'admin peut supprimer
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
 
}
