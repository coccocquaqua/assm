package com.example.assm.controller;

import com.example.assm.entity.Product;
import com.example.assm.service.admin.ProductService;
import com.example.assm.service.admin.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductAdminController {
@Autowired
ProductServiceImpl productService;

    @GetMapping("/index")
    public String index(Model model) {
        return "admin";
    }

    @GetMapping("/list_prod")
    public String showlistProduct(Model model) {
        //tạo thuộc tính model để liên kết dữ liệu form
        List<Product> productList=productService.getAll();
        System.out.println(productList.size());
        model.addAttribute("allProd", productList);

        return "list_product";
    }
    //code cho user
    @GetMapping("/man_prod")
    public String addNew(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "edit_prod";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("chucvu") Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable(value = "id") int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "updateChucVu";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }


}
