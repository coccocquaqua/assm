package com.example.assm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Product_Order")
public class ProducOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @JoinColumn(name = "ProductID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "OrderId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @Column(name = "Quantity")
    private float quantity;
    @Column(name = "price")
    private float price;
}
