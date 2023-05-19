package com.example.assm.controller;

import com.example.assm.model.ProductDetail;
import com.example.assm.service.user.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductDetailController {
    ProductDetailService productDetailService;
@Autowired
public ProductDetailController(ProductDetailService _productDetailService) {
    this.productDetailService = _productDetailService;
}
    @GetMapping("/detail")
    public String getAllProductDetails(Model model) {
        ProductDetail productDetail=new ProductDetail();
        model.addAttribute("product", productDetailService.getAllProductDetail());
        return "views/shop";
    }
/*    public List<ProductDetail> GetAll(){
        List<ProductDetail>productDetails=productService.getAllProduct();
        for (ProductDetail p:productDetails
             ) {
            System.out.println(p.toString()+"kkkk");
        }
        return  productDetails;
    }*/

    // other methods of ProductController

}
