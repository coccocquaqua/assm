package com.example.assm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @Column(name = "Product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @Column(name = "Quantity")
    private float quantity;
    @Column(name = "Price")
    private float price;
    @Column(name = "Status")
    private int status;
}