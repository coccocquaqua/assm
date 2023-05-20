package com.example.assm.service.user;

import com.example.assm.entity.Discount;
import com.example.assm.entity.Product;
import com.example.assm.entity.ProductDiscount;
import com.example.assm.model.ProductDetail;
import com.example.assm.repository.ProductDetailRepository;
import com.example.assm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductDetailService implements IProductDetailService {
private  final  ProductDetailRepository productDetailRepository;
private final ProductRepository productRepository;
    @Autowired
public ProductDetailService(ProductDetailRepository productRepository,
                            ProductRepository _productRepository){
    this.productDetailRepository=productRepository;
        this.productRepository=_productRepository;
}

/*    @Override
    public List<ProductDetail> getAllProductDetail() {
        return productRepository.getProductDetails();
    }*/
    @Override
    public List<ProductDetail> getAllProductDetail() {
        List<Product>productList=productRepository.findAll();
        List<ProductDetail>productDetailList=new ArrayList<>();
        for (Product product:productList
             ) {
            ProductDetail productDetail=new ProductDetail();
            productDetail.setName(product.getName());
            productDetail.setPrice(product.getPrice());
            productDetail.setImage(product.getImage());
            if(!product.getProductDiscounts().isEmpty()){
                ProductDiscount productDiscount=product.getProductDiscounts().iterator().next();
                Discount discount=productDiscount.getDiscount();
                productDetail.setPercentage(discount.getPercentage());

                    }
          productDetailList.add(productDetail);
        }
        return productDetailList;
    }

}
