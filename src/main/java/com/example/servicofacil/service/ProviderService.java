package com.example.servicofacil.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.ServiceDetail;
import com.example.servicofacil.repository.ProviderRepository;
import com.example.servicofacil.repository.ServiceRepository;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    //public List<Provider> findProviderByName(String login) {
    //    return providerRepository.findByLogin(login);
    //}

    public void providerSave(Provider provider) {

        Provider existProvider = providerRepository.findByLogin(provider.getLogin());

        if(existProvider != null){
            throw new Error("Usuario já existente");
        }

        provider.setPassword(passwordEncoder().encode(provider.getPassword()));
        providerRepository.save(provider);
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
