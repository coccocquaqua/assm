package com.example.assm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Product_Discount")
public class ProductDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @JoinColumn(name = "ProductId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "DiscountId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Discount discount;
}
