package com.example.assm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/index")
    public String home(){
        return "index";
    }
    @GetMapping("/login")
    public String logForm(){
        return "login";
    }
    @GetMapping("/register")
    public String regForm(){
        return "register";
    }
    @GetMapping("/product")
    public String showProd(){
        return "shop";
    }
//    @GetMapping("/order")
//    public String showOrder(){
//        return "order";
//    }
    @GetMapping("/cart")
    public String showCart(){
        return "cart";
    }

    @GetMapping("/list_prod")
    public String showlistProd(){
        return "list_product";
    }
    @GetMapping("/man_acc")
    public String editAcc(){
        return "edit_account";
    }
    @GetMapping("/man_prod")
    public String editProd(){
        return "edit_prod";
    }
    @GetMapping("/list_acc")
    public String showAcc(){
        return "list_account";
    }
    @GetMapping("/man_stProd")
    public String prodStatus(){
        return "product_status";
    }
}
