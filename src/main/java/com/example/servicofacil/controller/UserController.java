package com.example.servicofacil.controller;

import com.example.servicofacil.model.User;
import com.example.servicofacil.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/register-view")
    public String showUserRegister(Model model) {
        model.addAttribute("user", new User());
        return "user-register";
    }

        /**
     * Processa o salvamento de um usuário recebido do formulário de registro.
     * Valida o objeto de usuário e, em caso de erros, retorna à página de registro.
     * Retorna o nome da view dependendo do resultado da operação.
     */
    @PostMapping("/save")
    public String userSave(User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-register";
        }

        try {
            userService.userSave(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.reject("saveError", "Houve um erro ao salvar o usuário.");
            return "user-register";
        }

        return "provider/provider-list";
    }

    @GetMapping("/some-page")
    public String somePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName(); // ou obtenha o nome do usuário de outro modo, conforme necessário
        model.addAttribute("login", login);
        return "search"; // Retorna o nome da view
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