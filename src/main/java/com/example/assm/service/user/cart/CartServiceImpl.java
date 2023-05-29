package com.example.assm.service.user.cart;

import com.example.assm.entity.Product;
import com.example.assm.service.admin.ProductServiceImpl;
import com.example.assm.service.user.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class CartServiceImpl implements ICartService{
    @Autowired
    ProductServiceImpl productDetailService;
    Map<Integer, Product> map = new HashMap<>();

    @Override
    public Product add(int id) {
        Product product = map.get(id);

        if (product != null){
            product.setQuantity(product.getQuantity() + 1);
        } else {
            Product exProduct = productDetailService.getById(id);
            if (exProduct != null){
                exProduct.setQuantity(1);
                map.put(id, exProduct);
            }
        }
        return product;
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }

    @Override
    public Product update(int id, int quantity) {
        Product p = map.get(id);
        if (p != null){
            p.setQuantity(quantity);
        }
        return p;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Product> getProducts() {
        return map.values();
    }

    @Override
    public int getCount() {
        int count = 0;
        for (Product product : map.values()){
            count+=product.getQuantity();
        }
        return count;
    }

    @Override
    public double getAmount() {
        double amount = 0;
        for (Product product : map.values()){
            amount+=product.getQuantity() * product.getPrice();
        }
        return amount;
    }
}
