package com.example.assm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "OrderDate")
    private Date orderdate;
    @Column(name = "TotalAmount")
    private float totalamount;
    @Column(name = "UserID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToMany(mappedBy = "Orders",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ProducOrder> producOrderSet=new HashSet<>();
    @OneToMany(mappedBy = "Orders",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<OrderDetail> OrderDetails=new HashSet<>();
}
