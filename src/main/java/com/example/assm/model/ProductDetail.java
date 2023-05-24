package com.example.assm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Objects;

@Data
public class ProductDetail {
    private int id;
    private String name;
    private float price;
    private String image;
    public float Percentage;

    public ProductDetail() {
    }

    public ProductDetail(int id, String name, float price, String image, float percentage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        Percentage = percentage;
    }

    public ProductDetail(String name, float price, String image, float percentage) {
        this.name = name;
        this.price = price;
        this.image = image;
        Percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPercentage() {

       return Percentage;
    }


}
