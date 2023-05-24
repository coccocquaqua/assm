package com.example.assm.controller;

import com.example.assm.dto.UserDTO;
import com.example.assm.entity.User;
import com.example.assm.service.user.account.IAccountService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.HttpCookie;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private final IAccountService accountService;
    @Autowired
    HttpSession session;
    HttpCookie cookie;
    @Autowired
    public UserController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model,@ModelAttribute UserDTO userDTO ) {
        try {
            Optional<User> user = accountService.getUserById(userDTO.getUserId());

            if (user.isPresent() && user.get().getPassWord().equals(userDTO.getPassword())) {
                session.setAttribute("user", user);

                Cookie usernameCookie;
                if (userDTO.isRemember()) {
                    usernameCookie = new Cookie("username", String.valueOf(userDTO.getUserId()));
                    usernameCookie.setMaxAge(24 * 60 * 60); // 24 hours in seconds
                } else {
                    usernameCookie = new Cookie("username", "");
                    usernameCookie.setMaxAge(0); // Remove the cookie
                }
                response.addCookie(usernameCookie);

                request.setAttribute("isLogin", true);

                if (user.get().getRole()==true) {
                    return "forward:/admin/index";
                } else {
                    return "forward:/product/show";
                }
            } else {
                request.setAttribute("error", "Invalid username or password!!");
                return "forward:/user/login";
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            return "login";
        }
    }



    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model){
        return "login";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Validated @ModelAttribute("user") User user,
                               BindingResult result,
                               Model model){

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }

        accountService.saveAccount(user);
        return "redirect:/user/register";
    }

    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<User> users = accountService.getAllUser();
        model.addAttribute("users", users);
        return "list_account";
    }


}