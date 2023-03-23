package com.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository
    extends JpaRepository<Customer,Integer> {


    @Query("SELECT c FROM Customer c WHERE email=?1")
    Optional<Customer> searchCustomerEmail(String email);

    @Query("SELECT c FROM Customer c WHERE email=?1")
    Customer customerEmail (String email);






}
