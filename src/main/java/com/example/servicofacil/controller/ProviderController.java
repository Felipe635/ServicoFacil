package com.example.servicofacil.controller;

import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.ServiceDetail;
import com.example.servicofacil.model.User;
import com.example.servicofacil.service.ProviderService;
import com.example.servicofacil.service.ServiceDetailService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/provider")
@RequiredArgsConstructor
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @Autowired
    private ServiceDetailService detailService;

    //@GetMapping("/search/employer")
    //public List<Provider> searchEmployerByName(@RequestParam String username) {
    //    return providerService.findProviderByName(username);
    //}

    @GetMapping("/register-view")
    public String showProviderRegister(Model model) {
        model.addAttribute("provider", new Provider());
        return "provider-register";
    }

    @PostMapping("/save")
    public String userSave(Provider provider, BindingResult result) {
        if (result.hasErrors()) {
            return "user-register";
        }

        try {
            providerService.providerSave(provider);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.reject("saveError", "Houve um erro ao salvar o prestador.");
            return "cadastroServico";
        }

        return "cadastroServico";
    }
    
}
