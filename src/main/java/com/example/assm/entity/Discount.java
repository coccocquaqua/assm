package com.example.assm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Percentage")
    private int percentage;
    @Column(name = "StartDate")
    private Date startdate;
    @Column(name = "EndDate")
    private Date enddate;
    @OneToMany(mappedBy = "discount",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ProductDiscount> productDiscountSet=new HashSet<>();
}
