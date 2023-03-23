package com.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table

public class Orders {
    @Id
    @SequenceGenerator(
            name = "order_id_sequence",
            sequenceName = "order_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id_sequence"
    )

    private Integer id;

    private Integer customer_id;

    private Integer product_id;


    private Double product_price;

    private Integer quantity;

    @CreationTimestamp
    @Column(name = "order_date")
    private LocalDate order_date;

    @CreationTimestamp
    private Date order_timestamp;
    @UpdateTimestamp
    private Date last_update;



    private Integer refund;

    public Orders() {
    }


    public Orders(Integer customer_id, Integer product_id, Double product_price, Integer quantity){
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.product_price = product_price;
        this.quantity = quantity;
        this.refund = 0;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }


    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    public Date getOrder_timestamp(){
        return order_timestamp;
    }

    public void setOrder_timestamp(Date order_timestamp) {
        this.order_timestamp = order_timestamp;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
    public Integer getRefund() {
        return refund;
    }

    public void setRefund(Integer refund) {
        this.refund = refund;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getProduct_price() {
        return product_price;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", product_id=" + product_id +
                ", product_price=" + product_price +
                ", quantity=" + quantity +
                ", order_date=" + order_date +
                ", order_timestamp=" + order_timestamp +
                ", last_update=" + last_update +
                ", refund=" + refund +
                '}';
    }
}
