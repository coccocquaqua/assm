package com.example.assm.controller;

import com.example.assm.entity.Category;
import com.example.assm.entity.Product;
import com.example.assm.service.admin.ProductServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    HttpServletResponse response;
    @GetMapping("/index")
    public String index(Model model) {
        return "admin";
    }

    @GetMapping("/list_prod")
    public String showlistProduct(Model model) {
        //tạo thuộc tính model để liên kết dữ liệu form
        List<Product> productList = productService.getAll();
        System.out.println(productList.size());
        model.addAttribute("allProd", productList);

        return "list_product";
    }

    //code cho user
    @GetMapping("/man_prod")
    public String addNew(@ModelAttribute("prod") Product product, Model model) {
        model.addAttribute("product", product);
        return "edit_prod";
    }

    @PostMapping("/saveProd")
    @ResponseBody
    public String saveProduct(@ModelAttribute("prod") Product product) {
        if (product != null) {
            Category category = categoryService.findById(product.getCategory().getId());
            productService.saveProduct(product);
            response.setStatus(204);
        } else {
            response.setStatus(400);
        }
        return "redirect:/index";
    }
    @ModelAttribute("categories")
    public Map<Integer, String> getHobbies() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Lightning");
        map.put(2, "Type-C");
        return map;
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
