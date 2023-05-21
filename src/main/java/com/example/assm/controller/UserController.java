package com.example.assm.controller;

import com.example.assm.dto.LoginForm;
import com.example.assm.entity.User;
import com.example.assm.service.user.account.IAccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private final IAccountService accountService;

    @Autowired
    public UserController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            LoginForm loginForm = new LoginForm();
            Optional<User> user = accountService.getUserById(loginForm.getUserId());

            if (user.isPresent() && user.get().getPassword().equals(loginForm.getPassword())) {
                SessionUtils.add(request, "username", user.get().getName());

                if (loginForm.isRemember()) {
                    CookiesUtils.add("username", loginForm.getUserId(), 24, response);
                } else {
                    CookiesUtils.add("username", loginForm.getUserId(), 0, response);
                }

                request.setAttribute("isLogin", true);

                if (user.get().getRole()==true) {
                    return "forward:/HomeAdmin";
                } else {
                    return "forward:/Home";
                }
            } else {
                request.setAttribute("error", "Invalid username or password!!");
                return "forward:/Login";
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerForm(Model model, @ModelAttribute User user) {
        model.addAttribute("userForm", user); // UserForm là lớp đại diện cho thông tin đăng ký người dùng
        return "register";
    }
    @GetMapping("/account")
    public String getAll(Model model){
        List<User> list=accountService.getAllUser();
        model.addAttribute("listUser",list);
       return "list_account";
    }


}