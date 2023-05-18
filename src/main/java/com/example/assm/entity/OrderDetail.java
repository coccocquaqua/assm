package com.example.assm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @JoinColumn(name = "Order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @JoinColumn(name = "Product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @Column(name = "Quantity")
    private float quantity;
    @Column(name = "Price")
    private float price;
    @Column(name = "Status")
    private int status;
}
