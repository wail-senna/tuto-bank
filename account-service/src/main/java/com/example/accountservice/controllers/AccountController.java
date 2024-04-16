package com.example.accountservice.controllers;

import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.entities.Account;
import com.example.accountservice.models.Customer;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    AccountRepository accountRepository;
    CustomerRestClient customerRestClient;

    public AccountController(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable String id){
        Account account=accountRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }
}
