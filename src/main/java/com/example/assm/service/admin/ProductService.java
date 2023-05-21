package com.example.assm.service.admin;

import com.example.assm.entity.Product;
import com.example.assm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceImpl {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public Product getById(int id) {
        Optional<Product> optional = productRepository.findById(id);//xử lí vấn đề null
        Product product = null;
        if (optional.isPresent()) { // ispresent  có giá trị,
            product = optional.get();
        } else {
            System.out.println("prouct" + id);
        }

        return product;
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
