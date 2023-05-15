package com.example.assm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Category")
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "Id")
private int id;
@Column(name = "Name")
private String name;
    @OneToMany(mappedBy = "Category",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Product> productSet=new HashSet<>();

}
