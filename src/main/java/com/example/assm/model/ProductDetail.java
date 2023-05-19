package com.example.assm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ProductDetail {
    private int id;
    private String name;
    private float price;
    private String image;
    private int Percentage;

}
