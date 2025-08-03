package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  // ✅ avoid SQL reserved word 'user'
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public User() {}
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
}
