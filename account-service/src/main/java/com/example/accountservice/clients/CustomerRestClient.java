package com.example.accountservice.clients;

import com.example.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers")
    List<Customer> customerList();
    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id);


    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setNom("Not available");
        customer.setPrenom("Not available");
        customer.setEmail("Not available");

        return customer;
    }
}
