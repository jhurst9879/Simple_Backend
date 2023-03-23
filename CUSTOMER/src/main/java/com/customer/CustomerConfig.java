package com.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {
            Customer Bob = new Customer("BOB MARLEY","420@GMAIL.COM",35);
            Customer Jimi = new Customer("JIMI HENDRIX","PURPLEHAZE@GMAIL.COM",27);

            repository.saveAll(List.of(Bob,Jimi));

        };

    }
}
