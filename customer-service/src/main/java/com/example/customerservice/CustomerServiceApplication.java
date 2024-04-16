package com.example.customerservice;

import com.example.customerservice.config.GlobalConfig;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(GlobalConfig.class)
@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer customer=Customer.builder().nom("SENNA").prenom("Wail").email("wail@gmail.com").build();
            customerRepository.save(customer);
            Customer customer2=Customer.builder().nom("BELGHITI").prenom("Salah").email("salah@gmail.com").build();
            customerRepository.save(customer2);
        };
    }
}
