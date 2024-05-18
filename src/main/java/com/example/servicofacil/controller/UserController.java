package com.example.servicofacil.controller;

import com.example.servicofacil.model.User;
import com.example.servicofacil.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register-view")
    public String showUserRegister(Model model) {
        model.addAttribute("user",
                new User());
        return "user-registor";
    }

    @PostMapping("/save")
    public String userSave(@Valid @ModelAttribute("user") User user, BindingResult result) {

        if (result.hasErrors()) {
            return "user-register";
        }

        try {
            userService.userSave(user);
        } catch (Exception ex) {

        }

        return "redirect:/nav-bar";
    }

    @PostMapping("/signin")
    public String userSignin(@ModelAttribute("user") User user, BindingResult result) {

        try {
            var userList = userService.UserGetByLogin(user);

            if (userList.isEmpty()) {
            } else {
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return "redirect:/nav-bar";
    }
}
