package com.product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository
        extends JpaRepository<Product,Integer> {

        @Query(value = "SELECT * FROM Product p WHERE product_name=?1", nativeQuery = true)
    Optional<Product> searchProductByNAme(String product_name);



}
