package com.example.servicofacil.controller;

import com.example.servicofacil.model.User;
import com.example.servicofacil.service.UserService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
private UserService userService;
public UserController(UserService userService){
    this.userService = userService;
}
    @PostMapping("/save")
    public String processarFormulario(@Valid @RequestBody User user, BindingResult result){

    if(result.hasErrors()){
            return "cadastro-cli";
        }

        try {
             userService.userSave(user);
        }catch (Exception ex){

        }

        return "redirect:/nav-bar";
    }
}
