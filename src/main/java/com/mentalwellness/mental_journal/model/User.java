package com.mentalwellness.mental_journal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data   // Generates getters, setters, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    // private String password;  // Optional – can be skipped or hashed later
}
