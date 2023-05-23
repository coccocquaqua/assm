package com.example.assm.repository;

import com.example.assm.entity.Product;
import com.example.assm.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductUserRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new com.example.assm.model.ProductDetail(p.name, p.price, p.image, d.percentage) " +
            "FROM Product p " +
            "JOIN p.productDiscounts pd " +
            "JOIN pd.discount d ")
        //"order by (p.price * (1-d.percentage)) DESC")
    List<ProductDetail> getProductDetails();

    //xem chi tiết product
    @Query("SELECT new com.example.assm.model.ProductDetail(p.id,p.name, p.price, p.image, d.percentage) " +
            "FROM Product p " +
            "JOIN p.productDiscounts pd " +
            "JOIN pd.discount d " +
            "WHERE p.id = :productId")
    ProductDetail getProductDetailsByProductId(@Param("productId") int productId);

//phân trang product
    @Query("SELECT new com.example.assm.model.ProductDetail(p.name, p.price, p.image, d.percentage) " +
            "FROM Product p " +
            "JOIN p.productDiscounts pd " +
            "JOIN pd.discount d")
    List<ProductDetail> getProductDetailWithCondition(Pageable pageable);


    @Query("SELECT new com.example.assm.model.ProductDetail(p.name, p.price, p.image, d.percentage) " +
            "FROM Product p " +
            "JOIN p.productDiscounts pd " +
            "JOIN pd.discount d " +
            "JOIN p.category c " +
            "WHERE c.name = :categoryName")
    List<ProductDetail> getProductByCategoryName(@Param("categoryName") String CategoryName);

}
