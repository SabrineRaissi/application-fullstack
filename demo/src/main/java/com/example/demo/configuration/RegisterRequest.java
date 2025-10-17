package com.example.demo.configuration;

public class RegisterRequest {
private String nom;
    private String email;
    private Integer age;
    private String password;
    public RegisterRequest() {}
    public RegisterRequest(String nom, String email, Integer age, String password) {
    this.nom = nom;
        this.email = email;
        this.age = age;
        this.password = password;
    }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    }
