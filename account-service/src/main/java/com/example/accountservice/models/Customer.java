package com.example.accountservice.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Customer {
    Long id;
    String nom;
    String prenom;
    String email;

}
