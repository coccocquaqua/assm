package com.example.assm.controller;

import com.example.assm.dto.ProductDTO;
import com.example.assm.model.ProductDetail;
import com.example.assm.model.ProductDetailPage;
import com.example.assm.service.user.IProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/product")
public class ProductController {




    IProductDetailService productDetailService;
    @Autowired
    public ProductController(IProductDetailService _productDetailService) {
        this.productDetailService = _productDetailService;
    }

    //get all product
    @GetMapping("/show")
    public String getAllProduct(Model model) {
        List<ProductDetail> productDetailList = productDetailService.getAllProduct();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (ProductDetail p : productDetailList) {
            ProductDTO productDTO = new ProductDTO(p);
            productDTOS.add(productDTO);
        }
        model.addAttribute("product", productDTOS);
        return "shop";
    }
//get one product (xem chi tiết sản phẩm)

    @GetMapping("/ShowOne/{IdProduct}")
    public String getOneProductDetail(@PathVariable(value = "IdProduct") int idProduct, Model model) {
        ProductDetail productDetail = productDetailService.GetProductById(idProduct);
        if (productDetail == null) {
            return "shop";
        }
        model.addAttribute("prod", productDetail);
        return "order";
    }
/*@GetMapping("/{productId}")
public ResponseEntity<ProductDetail> getProductDetailByProductId(@PathVariable int productId) {
    ProductDetail productDetail = productDetailService.GetProductById(productId);
    if (productDetail == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(productDetail);
}*/

    @GetMapping("/page")
    public String getProducts(@RequestParam("page") int page, Model model) {
        int pageSize = 1;
        ProductDetailPage productPage = productDetailService.getProductWithCondition(page, pageSize);
        model.addAttribute("productDetailPage", productPage);
        return "shop";
    }

    @GetMapping("/Category/{name}")
    public String getProductByCategoryName(@PathVariable("name") String categoryName, Model model) {
        System.out.println(categoryName);
        List<ProductDetail> productDetailList = productDetailService.getProductByCategoryName(categoryName);
        System.out.println(productDetailList.toString());
       if(productDetailList.isEmpty()){
           return "noContentView";
       }
        model.addAttribute("product", productDetailList);
        return "shop";
    }
}
