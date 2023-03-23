package com.order;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class OrderController {

    private final OrderService orderService;


    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @GetMapping(path = ("/api/order"))
    public List<Orders>getOrders(){
        return orderService.getOrders();
    }

    @PostMapping(path =("/api/order"))
    public void registerNewOrder(@RequestParam(required = true) Integer customer_id,
                                  @RequestParam(required = true)  Integer product_id,
                                    @RequestParam(required = false,defaultValue = "1") Integer quantity){

        orderService.addNewOrder(customer_id, product_id, quantity);

    }
    @PutMapping(path = "api/order/{customerId}")
    public void updateCustomer (@PathVariable("customerId") Integer customerID,
                                @RequestParam Integer refund)
     {
        orderService.updateOrder(customerID,refund);
    }

}


