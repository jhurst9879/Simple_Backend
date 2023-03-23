package com.product;

import com.order.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner2(ProductRepository repository) {
        return args -> {
            Product Test1 = new Product("Fender Stratocaster",405.99);
            Product Test2 = new Product("Ibanez Guitar",299.99);

            repository.saveAll(List.of(Test1, Test2));

        };
    }
}
