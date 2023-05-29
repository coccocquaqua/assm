package com.example.assm.service.user.cart;

import com.example.assm.entity.Product;

import java.util.Collection;

public interface ICartService {
    Product add(int id);

    void remove(int id);

    Product update(int id, int quantity);

    void clear();

    Collection<Product> getProducts();

    int getCount();

    double getAmount();

}
