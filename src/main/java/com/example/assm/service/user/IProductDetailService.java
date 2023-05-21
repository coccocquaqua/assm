package com.example.assm.service.user;

import com.example.assm.model.ProductDetail;

import java.util.List;

public interface IProductDetailService {

    List<ProductDetail>getAllProduct();
    ProductDetail GetProductById(int productId);
    ProductDetail getProductWithCondition(int page, int pageSize);

    List<ProductDetail>getProductByCategoryName(String CategoryName);


}
