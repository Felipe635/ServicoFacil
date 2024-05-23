package com.example.servicofacil.controller;

import com.example.servicofacil.model.Provider;
import com.example.servicofacil.service.ProviderService;
import com.example.servicofacil.service.ServiceDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("provider-list")
    public String getProviders(Model model) {
        List<Provider> providers = providerService.findAll();
        model.addAttribute("providers", providers);
        return "search";
    }

    @GetMapping("search")
    public String seuMetodo(@RequestParam("search") String search, Model model) {
        List<Provider> providers = providerService.findByServiceName(search);
        model.addAttribute("providers", providers);
        return "search";
    }

    @GetMapping("/register-view")
    public String showProviderRegister(Model model) {
        model.addAttribute("provider", new Provider());
        return "provider-register";
    }

/*    @PostMapping("/save")
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
    }*/
    
}
