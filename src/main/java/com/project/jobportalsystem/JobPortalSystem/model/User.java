package com.project.jobportalsystem.JobPortalSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "users") // better to use plural for table names
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    // This was rollNO, probably meant role (use Enum instead of int)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime createdAt;

    // Constructors, Getters, Setters (Lombok can be used to avoid boilerplate)
}
