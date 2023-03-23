package com.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping

public class CustomerController{
    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping(path = ("/api/Customer"))
    public List<Customer>getCustomer(){
        return customerService.getCustomer();
    }

    @GetMapping(path = "/api/Customer/{customerId}")
    public Customer getCustById(@PathVariable("customerId") Integer customerID){return customerService.getCustById(customerID);}

    @GetMapping(path = "/api/Customer/email/{email}")
    public Customer getCustByEmail(@PathVariable("email") String email){return customerService.getCustByEmail(email);}

    @PostMapping(path = "/api/Customer")
    public void registerNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);

    }
    @PutMapping(path = "api/Customer/{customerId}")
    public void updateCustomer (@PathVariable("customerId") Integer customerID,
                                        @RequestParam(required = false) String email,
                                        @RequestParam(required = false) String name
                                        ) {
        customerService.updateCustomer(customerID,name, email);
    }
    @DeleteMapping(path = "api/Customer/{customerId}" )
    public void deleteCustomer(@PathVariable("customerId") Integer customerID){
        customerService.deleteCustomer(customerID);
    }

}
