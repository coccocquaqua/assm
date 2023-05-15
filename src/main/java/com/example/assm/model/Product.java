package com.example.assm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Names")
    private int name;
    @Column(name = "Price")
    private int price;
    @Column(name = "Image")
    private int image;
    @Column(name = "CategoryID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @OneToMany(mappedBy = "Products",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ProducOrder> producOrder=new HashSet<>();
    @OneToMany(mappedBy = "Products",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ProductDiscount> productDiscounts=new HashSet<>();
    @OneToMany(mappedBy = "Products",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<OrderDetail> productDetails=new HashSet<>();
}
