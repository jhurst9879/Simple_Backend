package com.order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository
        extends JpaRepository<Orders,Integer> {

    @Query(value = "SELECT email FROM ORDERS WHERE customer_id=?1", nativeQuery = true)
    Optional<Orders> searchCustomer(Integer customer_id);


}
