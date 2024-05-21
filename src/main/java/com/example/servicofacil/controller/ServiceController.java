package com.example.servicofacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.servicofacil.model.ServiceDetail;
import com.example.servicofacil.service.ServiceDetailService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {
 
    @Autowired
    private ServiceDetailService detailService;

    
    @PostMapping("/saveService")
    public String serviceSave(ServiceDetail serviceDetail, BindingResult result) {
        if (result.hasErrors()) {
            return "user-register";
        }

        try {
            detailService.serviceSave(serviceDetail);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.reject("saveError", "Houve um erro ao salvar o prestador.");
            return "cadastroServico";
        }

        return "search";
    }
}