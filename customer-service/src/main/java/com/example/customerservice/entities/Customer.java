package com.example.customerservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String prenom;
    String email;
}
