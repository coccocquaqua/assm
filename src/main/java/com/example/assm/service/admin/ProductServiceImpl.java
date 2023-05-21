package com.example.assm.service.admin;

import com.example.assm.entity.Product;

import java.util.List;

public interface ProductServiceImpl {
    List<Product> getAll();
    void saveProduct(Product product);
    Product getById(int id);
    void deleteProduct(int id);


}
