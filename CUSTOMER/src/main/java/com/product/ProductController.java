package com.product;

import com.customer.Customer;
import com.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(path = ("/api/product"))
    public List<Product> getProduct(){
        return productService.getProducts();
    }
    @GetMapping(path = ("/api/product/{product_id}"))
    public Product getProductByID(@PathVariable("product_id") Integer product_id){
        return productService.getProductById(product_id);
    }
    @GetMapping(path = ("/api/product/name/{product_name}"))
    public Product getProductByName(@PathVariable("product_name") String product_name){
        return productService.getProductByName(product_name);
    }

    @PostMapping(path = ("/api/product"))
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PutMapping(path =("/api/product/{product_id}") )
    public void updateProduct(@PathVariable("product_id") Integer product_id,
                               @RequestParam(required = false, defaultValue = "0") Integer end_date_indicator,
                              @RequestParam(required = false, defaultValue = "0") Double product_price){
        productService.updateProduct(product_id, product_price, end_date_indicator);

    }


}
