package com.example.assm.service.admin;

import com.example.assm.entity.Discount;
import com.example.assm.entity.Product;
import com.example.assm.entity.ProductDiscount;

import java.util.List;

public interface ProductServiceImpl {
    List<Product> getAll();
    void saveProduct(Product product, ProductDiscount productDiscount, Discount discount);
    Product getById(int id);
    void deleteProduct(int id);


}
