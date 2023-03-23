package com.order;

import com.customer.Customer;
import com.customer.CustomerRepository;
import com.product.Product;
import com.product.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private  final CustomerRepository customerRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public List<Orders> getOrders() {
        return orderRepository.findAll();

    }

    public Orders getOrderById(int orderId) {
        Orders orders = orderRepository.findById(orderId).orElseThrow
                (() -> new IllegalStateException("customer_id with id " + orderId + " does not exist."));
        return orders;
    }

    public void addNewOrder(Integer customer_id, Integer product_id, Integer quantity) {

       Customer customer= customerRepository.findById(customer_id).orElseThrow(() -> new IllegalStateException("customer_id with id "+ customer_id +" does not exist"));
       Product product= productRepository.findById(product_id).orElseThrow(() -> new IllegalStateException("product_id with id "+ product_id +" does not exist"));
       Double product_price = product.getProduct_price();

       if (quantity<1){
           throw new IllegalStateException("Quantity can't be less than 1");
       }

        Orders orders = new Orders (customer_id, product_id, product_price, quantity);



        orderRepository.save(orders);
    }

    @Transactional
    public void updateOrder (Integer customerId, Integer refund) {
        Orders orders  = orderRepository.findById(customerId).orElseThrow
                (() -> new IllegalStateException("customer_id with id " + customerId + " does not exist."));
        if (refund != 1 ){
            throw new IllegalStateException("refund indicator must be 1");
        }
        orders.setRefund(refund);

    }
}






