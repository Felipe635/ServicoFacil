package com.example.servicofacil.controller;

import com.example.servicofacil.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/search")
    public String exibirBusca(){
        return "search_guest";
    }

    @GetMapping("/client-dashboard")
    public String exibirPerfilCliente(){
        return "client-dashboard";
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