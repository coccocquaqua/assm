package com.example.assm.service.user;

import com.example.assm.model.ProductDetail;
import com.example.assm.model.ProductDetailPage;
import com.example.assm.repository.ProductUserRepository;
import com.example.assm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class ProductDetailService implements IProductDetailService {
    private final ProductUserRepository productUserRepository;
    private final ProductRepository productRepository;
    @Autowired
    public ProductDetailService(ProductUserRepository productRepository,
                                ProductRepository _productRepository) {
        this.productUserRepository = productRepository;
        this.productRepository = _productRepository;
    }

    @Override
    public List<ProductDetail> getAllProduct() {
        List<ProductDetail> productDetails = productUserRepository.getProductDetails();
        List<ProductDetail> discountedProducts = new ArrayList<>();
        List<ProductDetail> nonDiscountedProducts = new ArrayList<>();
        for (ProductDetail productDetail : productDetails) {
            if(productDetail.getPercentage()>0){
                float calculatedPrice = productDetail.getPrice()-(productDetail.getPrice() *( productDetail.getPercentage()/100));
                productDetail.setPrice(calculatedPrice);
                discountedProducts.add(productDetail);
            }

            nonDiscountedProducts.add(productDetail);
        }
        discountedProducts.sort(Comparator.comparing(ProductDetail::getPrice).reversed());
        discountedProducts.addAll(nonDiscountedProducts);
        return productDetails;
    }

    @Override
    public ProductDetail GetProductById(int productId) {

        return productUserRepository.getProductDetailsByProductId(productId);
    }

    @Override
    public ProductDetailPage getProductWithCondition(int page, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(page, pageSize);
        List<ProductDetail> productDetailList = productUserRepository.getProductDetailWithCondition(pageable);
        int totalPages = (int) Math.ceil((double) productUserRepository.count() / pageSize);
        return new ProductDetailPage(productDetailList, page, totalPages);
    }

    @Override
    public List<ProductDetail> getProductByCategoryName(String CategoryName) {
        List<ProductDetail> productDetails = productUserRepository.getProductByCategoryName(CategoryName);
        List<ProductDetail> discountedProducts = new ArrayList<>();
        List<ProductDetail> nonDiscountedProducts = new ArrayList<>();
        for (ProductDetail productDetail : productDetails) {
            if(productDetail.getPercentage()>0){
                float calculatedPrice = productDetail.getPrice()-(productDetail.getPrice() *( productDetail.getPercentage()/100));
                productDetail.setPrice(calculatedPrice);
                discountedProducts.add(productDetail);
            }
            nonDiscountedProducts.add(productDetail);
        }
        discountedProducts.sort(Comparator.comparing(ProductDetail::getPrice).reversed());
        discountedProducts.addAll(nonDiscountedProducts);
        return productDetails;
    }


  /*  @Override
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
    }*/

}
