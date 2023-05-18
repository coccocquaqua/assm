package com.example.assm.repository;

import com.example.assm.entity.Product;
import com.example.assm.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

@Query("select new com.example.assm.model.ProductDetail(p.name ,p.price, p.image, d.percentage) from ProductDiscount pd " +
        " join pd.product p " +
        " join pd.discount d  " )
List<ProductDetail> getProductDetails();


}
