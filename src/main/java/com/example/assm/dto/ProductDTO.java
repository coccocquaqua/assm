package com.example.assm.dto;

import com.example.assm.model.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private float price;
    private String image;
    private float percentage;
    private float discountedPrice;

    public ProductDTO(ProductDetail productDetail) {
        this.id = productDetail.getId();
        this.name = productDetail.getName();
        this.price = productDetail.getPrice();
        this.image = productDetail.getImage();
        this.percentage = productDetail.getPercentage();

        if (percentage > 0){
            this.discountedPrice = price - (price * (percentage / 100));
        } else {
            this.discountedPrice = price;
        }
    }

}
