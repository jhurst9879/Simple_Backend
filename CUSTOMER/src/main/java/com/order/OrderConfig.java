package com.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class OrderConfig {
    @Bean
    CommandLineRunner commandLineRunner1(OrderRepository repository) {
        return args -> {
//            Orders Test1 = new Orders(1, 1, 2);
////            Orders Test2 = new Orders( 2, 2 );
//
//            repository.saveAll(List.of(Test1));

        };
    }
}

