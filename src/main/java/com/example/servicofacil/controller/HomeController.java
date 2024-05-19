package com.example.servicofacil.controller;

import com.example.servicofacil.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String exibirFormularioLogin(Model model){
        model.addAttribute("user",
                new User());
        return "login";
    }

    @PostMapping("/login")
    public String processarFormularioLogin(@Valid @ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            return "user-register";
        }
        return "redirect:/login";
    }

    @GetMapping("/cadastro")
    public String exibirFormulario(Model model){
        model.addAttribute("user",
                new User());
        return "user-register";
    }

    @PostMapping("/cadastro")
    public String processarFormulario(@Valid @ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            return "user-register";
        }
        return "redirect:/nav-bar";
    }

    @GetMapping("/nav-bar")
    public String exibirSucesso() {
        return "nav-bar";
    }
    @GetMapping("/")
    public String home() {
        return "nav-bar";
    }

}