package com.product;



import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();

    }
    public Product getProductById(Integer product_id){
        Product product = productRepository.findById(product_id).orElseThrow( () -> new IllegalStateException("Product Id " + product_id +" does not exist"));
        return product;

    }
    public Product getProductByName(String product_name) {
        System.out.println("This is "+   product_name);
        Product product = productRepository.searchProductByNAme(product_name).orElseThrow( () -> new IllegalStateException("Product name " + product_name +" does not exist"));
        return product;
    }
    public void addProduct(Product product){
        productRepository.save(product);
    }
    @Transactional
    public void updateProduct(Integer product_id, Double product_price, Integer end_date_indicator){
        Date end_date = new Date();

        Product product = productRepository.findById(product_id).orElseThrow( () -> new IllegalStateException("Product Id " + product_id +" does not exist"));
        if (product.getEnd_date() != null){
            throw  new IllegalStateException("This product has been end dated no new updates can be made");
        }

        if (product_price > 0 && end_date_indicator == 0){
            product.setProduct_price(product_price);

        }
        else if (product_price <0 || (end_date_indicator == 1 && product_price >0 )){
            throw  new IllegalStateException("Price should be greater than 0 or end date indicator should not be 1 when updating product price");
        }


        if(end_date_indicator != 0 && end_date_indicator !=1){
            throw new IllegalStateException("End date indicator must be 0 or 1");
        }
        else if (end_date_indicator == 1){
            product.setEnd_date(end_date);

        }



    }



}
