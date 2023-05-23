package com.example.assm.controller;

import com.example.assm.model.ProductDetail;
import com.example.assm.model.ProductDetailPage;
import com.example.assm.service.user.IProductDetailService;
import com.example.assm.service.user.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/productuser")
public class ProductUserController {


    // code cho admin


    IProductDetailService productDetailService;
    @Autowired
    public ProductUserController(IProductDetailService _productDetailService) {
        this.productDetailService = _productDetailService;
    }

    //get all product
    @GetMapping("/show")
    public String getAllProduct(Model model) {
        List<ProductDetail> productDetailList = productDetailService.getAllProduct();
        model.addAttribute("product", productDetailList);
        return "shop";
    }
//get one product (xem chi tiết sản phẩm)

    @GetMapping("/ShowOne/{IdProduct}")
    public String getOneProductDetail(@PathVariable(value = "IdProduct") int idProduct, Model model) {
        ProductDetail productDetail = productDetailService.GetProductById(idProduct);
        if (productDetail == null) {
            return "productNotFound";
        }
        model.addAttribute("productId", productDetail);
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
    public String GetPageProductDetail(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int pageSize,
            Model model) {
        ProductDetailPage productDetailPage =  productDetailService.getProductWithCondition(page, pageSize);
        model.addAttribute("productDetailPage", productDetailPage);
        return "shop";
    }

    @GetMapping("/Category/{name}")
    public String getProductByCategoryName(@PathVariable String categoryName, Model model) {

        List<ProductDetail> productDetailList = productDetailService.getProductByCategoryName(categoryName);
       if(productDetailList.isEmpty()){
           return "noContentView";
       }
        model.addAttribute("product", productDetailList);
        return "shop";
    }
}
