package com.example.assm.controller;

import com.example.assm.service.user.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ICartService cart;
    @GetMapping()
    public String viewCart(Model model){
        model.addAttribute("cart", cart);
        return "cart";
    }
    @RequestMapping("/add/{id}")
    public String addtoCart(@PathVariable("id") Integer id){
        cart.add(id);
        return "forward:/cart";
    }
    @ModelAttribute("count")
    public int getCountProd(){
        int count = 0;
        if (cart != null){
            count = cart.getCount();
        }
        return count;
    }
    @ModelAttribute("amount")
    public double getAmount(){
        double amount = 0;
        if (cart != null){
            amount = cart.getAmount();
        }
        return amount;
    }
    @RequestMapping("/update/{id}")
    public String updateCart(@PathVariable("id") Integer id,
                             @RequestParam("quantity") Integer qty) {
        cart.update(id, qty);
        return "redirect:/cart";
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "redirect:/cart";
    }
}
