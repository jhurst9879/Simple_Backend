package com.customer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomer() {
        return customerRepository.findAll();

    }
    public Customer getCustById(int customerId ){
        Customer customer = customerRepository.findById(customerId).orElseThrow
                (() -> new IllegalStateException("customer_id with id " + customerId + " does not exist."));
        return customer;
    }

    public Customer getCustByEmail (String email){
        Customer customer = customerRepository.searchCustomerEmail(email.toUpperCase()).orElseThrow
                (() -> new IllegalStateException("customer with email " + email + " does not exist."));
        return customer;
    }

    public void addNewCustomer(Customer customer) {
        String email = customer.getEmail().toUpperCase();
        Optional<Customer> searchEmail = customerRepository.searchCustomerEmail(email);
        if (searchEmail.isPresent()) {

            throw new IllegalStateException("Email is already present in Database");
        }

        if (emailVal(customer.getEmail()) == false) {
            throw new IllegalStateException("Invalid Email Address");
        } else {
            customerRepository.save(customer);
        }
    }

    @Transactional
    public void updateCustomer(Integer customerId, String name, String email) {
        boolean valid_name = false;
        boolean valid_email = false;
       Customer customer = customerRepository.findById(customerId).orElseThrow
                (() -> new IllegalStateException("customer_id with id " + customerId + " does not exist."));
        if (name != null && name.length() > 0 && !Objects.equals(name.toUpperCase(), customer.getName())) {
            valid_name = true;
            customer.setName(name.toUpperCase());
        }
        else if (name != null && name.length() > 0 && valid_name == false) {
            throw new IllegalStateException("Invalid name");

        }



        if (email != null && email.length() > 0  && emailVal(email)) {
            Optional<Customer> searchEmail = customerRepository.searchCustomerEmail(email.toUpperCase());
            if (searchEmail.isPresent()) {
                throw new IllegalStateException("Email Already Exists in Database");
            }
            valid_email = true;

            customer.setEmail(email.toUpperCase());

        }
        else if (email != null && email.length() > 0 && valid_email == false) {
            throw new IllegalStateException("Invalid email");

        }


    }
    public void deleteCustomer(Integer customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow
                (() -> new IllegalStateException("customer_id with id " + customerId + " does not exist."));
        customerRepository.delete(customer);
    }

    private boolean emailVal(String email) {
        String regexPattern = "^(.+)@(\\S+)$";
        Pattern pattern = Pattern.compile(regexPattern);

        if (email.matches(regexPattern)) {
            return true;
        } else {
            return false;
        }
    }

}
