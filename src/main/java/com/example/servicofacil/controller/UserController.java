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
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register-view")
    public String showUserRegister(Model model) {
        model.addAttribute("user", new User());
        return "user-register";
    }

    @PostMapping("/save")
    public String userSave(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "cadastro-cli";
        }

        try {
            userService.userSave(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.reject("saveError", "Houve um erro ao salvar o usuário.");
            return "cadastro-cli";
        }

        return "redirect:/nav-bar";
    }

    @PostMapping("/signin")
    public String userSignin(@ModelAttribute("user") User user, BindingResult result) {
        try {
            var userList = userService.UserGetByLogin(user);

            if (userList.isEmpty()) {
                result.reject("loginError", "Credenciais inválidas.");
                return "login-view";
            } else {
                return "redirect:/user-dashboard";
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}