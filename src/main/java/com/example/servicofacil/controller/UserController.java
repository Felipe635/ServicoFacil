package com.example.servicofacil.controller;

import com.example.servicofacil.model.User;
import com.example.servicofacil.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/register-view")
    public String showUserRegister(Model model) {
        model.addAttribute("user", new User());
        return "user-register";
    }

    @PostMapping("/save")
    public String userSave(@RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-register";
        }

        try {
            userService.userSave(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.reject("saveError", "Houve um erro ao salvar o usuário.");
            return "cadastro-cli";
        }

        return "cadastrado";
    }

/*    @PostMapping("/signin")
    public String userSignin(@ModelAttribute("user") User user, BindingResult result) {
        try {
            var userList = userService.findByLogin(user);

            if (userList) {
                result.reject("loginError", "Credenciais inválidas.");
                return "login-view";
            } else {
                return "redirect:/user-dashboard";
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }*/
}