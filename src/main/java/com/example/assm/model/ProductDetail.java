package com.example.assm.model;

import lombok.Data;

@Data
public class ProductDetail {
    private String name;
    private float price;
    private String image;
    private  int Percentage;

    public ProductDetail() {
    }

    public ProductDetail(String name, float price, String image, int percentage) {
        this.name = name;
        this.price = price;
        this.image = image;
        Percentage = percentage;
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

    public int getPercentage() {
        return Percentage;
    }

    public void setPercentage(int percentage) {
        Percentage = percentage;
    }
}
