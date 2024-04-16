package com.example.accountservice.entities;

import com.example.accountservice.enums.AccountType;
import com.example.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Account {
    @Id
    private String accountId;
    private double solde;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
