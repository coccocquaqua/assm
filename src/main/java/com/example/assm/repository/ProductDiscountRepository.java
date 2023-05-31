package com.example.assm.repository;

import com.example.assm.entity.ProductDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDiscountRepository extends JpaRepository<ProductDiscount,Integer> {
    @Modifying
    @Query("DELETE FROM ProductDiscount pd WHERE pd.product.id = :productId")
    void deleteByProductId(@Param("productId") int productId);
}
