package com.example.assm.controller;

import com.example.assm.entity.Product;
import com.example.assm.service.admin.ProductService;
import com.example.assm.service.admin.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productadmin")
public class ProductAdminController {
@Autowired
ProductServiceImpl productService;

    @GetMapping("/")
    public String showlistProduct(Model model) {
        //tạo thuộc tính model để liên kết dữ liệu form
        Product product=new Product();
        model.addAttribute("chucvu", productService.getAll());

        return "Index";
    }
    //code cho user
    @GetMapping("/addnew")
    public String addNew(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "newProduct";
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
