package com.example.assm.repository;

import com.example.assm.entity.Product;
import com.example.assm.model.ProductDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUserRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new com.example.assm.model.ProductDetail(p.id, p.name, p.price, p.image, COALESCE(d.percentage, 0)) " +
            "FROM Product p " +
            "LEFT JOIN p.productDiscounts pd " +
            "LEFT JOIN pd.discount d ")
        //"order by (p.price * (1-d.percentage)) DESC")
    List<ProductDetail> getProductDetails();

    //xem chi tiết product
    //bắt buộc phải có discount thì mới tìm ra sản phẩm
    @Query("SELECT new com.example.assm.model.ProductDetail(p.id, p.name, p.price, p.image, d.percentage) " +
            "FROM Product p " +
            "JOIN p.productDiscounts pd " +
            "JOIN pd.discount d " +
            "WHERE p.id = :IdProduct")
    ProductDetail getProductDetailsByProductId(@Param("IdProduct") int IdProduct);

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
