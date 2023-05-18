package com.example.assm.controller;

import com.example.assm.model.ProductDetail;
import com.example.assm.service.user.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@RequestMapping("/products")
public class ProductController {

@Autowired
ProductService productService;
    @GetMapping("/detail")
    public String getAllProductDetails(Model model) {
        ProductDetail productDetail=new ProductDetail();
        model.addAttribute("product",productService.getAllProduct());
        return "views/shop";
    }

    // other methods of ProductController

}
