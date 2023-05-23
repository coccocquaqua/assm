package com.example.assm.service.user;

import com.example.assm.model.ProductDetail;
import com.example.assm.model.ProductDetailPage;

import java.util.List;

public interface IProductDetailService {

    List<ProductDetail>getAllProduct();
    ProductDetail GetProductById(int productId);
    ProductDetailPage getProductWithCondition(int page, int pageSize);

    List<ProductDetail>getProductByCategoryName(String CategoryName);


}
