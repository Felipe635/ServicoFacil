package com.example.servicofacil.controller;

import com.example.servicofacil.model.Provider;
import com.example.servicofacil.service.ProviderService;
import com.example.servicofacil.service.ServiceDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/provider")
@RequiredArgsConstructor
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @Autowired
    private ServiceDetailService detailService;

    @GetMapping("provider-list")
    public String getProviders(Model model) {
        List<Provider> providers = providerService.findAll();
        model.addAttribute("providers", providers);
        return "search";
    }

    @GetMapping("search")
    public String search(@RequestParam("search") String search, Model model) {
        List<Provider> providers = providerService.findByServiceName(search);
        model.addAttribute("providers", providers);
        return "search";
    }

    @GetMapping("/register-view")
    public String showProviderRegister(Model model) {
        model.addAttribute("provider", new Provider());
        return "provider-register";
    }

    @GetMapping("/detail/{IdProvider}")
    public String getProvider(@PathVariable("IdProvider") String providerID, Model model) {
        Optional<Provider> provider = providerService.findProviderByID(Integer.parseInt( providerID));
        model.addAttribute("provider", provider.get());
        return "provider-details";
    }

}
