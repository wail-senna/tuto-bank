package com.example.accountservice;

import com.example.accountservice.config.GlobalConfig;
import com.example.accountservice.entities.Account;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;
@EnableConfigurationProperties(GlobalConfig.class)
@EnableFeignClients
@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> {
            Account account=Account.builder().accountId(UUID.randomUUID().toString()).solde(5000).createdAt(LocalDate.now()).type(AccountType.CURRENT_ACCOUNT).currency("MAD").customerId(1L).build();
            accountRepository.save(account);
            Account account2=Account.builder().accountId(UUID.randomUUID().toString()).solde(3000).createdAt(LocalDate.now()).type(AccountType.CURRENT_ACCOUNT).currency("MAD").customerId(2L).build();
            accountRepository.save(account2);
        };
    }
}
