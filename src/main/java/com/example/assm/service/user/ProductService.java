package com.example.assm.service.user;

import com.example.assm.model.ProductDetail;
import com.example.assm.repository.ProductRepository;
import com.example.assm.service.user.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
@Autowired
private ProductRepository productRepository;
    @Override
    public List<ProductDetail> getAllProduct() {
        return productRepository.getProductDetails();
    }
}
