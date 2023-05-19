package com.example.assm.repository;

import com.example.assm.entity.Product;
import com.example.assm.entity.ProductDiscount;
import com.example.assm.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<Product,Integer>{

    @Query("SELECT new com.example.assm.model.ProductDetail(p.name, p.price, p.image, d.percentage) " +
            "FROM Product p " +
            "JOIN p.productDiscounts pd " +
            "JOIN pd.discount d")
    List<ProductDetail> getProductDetails();

}
