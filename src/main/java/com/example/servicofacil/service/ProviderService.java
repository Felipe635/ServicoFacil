package com.example.servicofacil.service;


import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.ServiceDetail;
import com.example.servicofacil.repository.ProviderRepository;
import com.example.servicofacil.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    //public List<Provider> findProviderByName(String login) {
    //    return providerRepository.findByLogin(login);
    //}

/*    public void providerSave(Provider provider) {


        if(existProvider != null){
            throw new Error("Usuario já existente");
        }

        providerRepository.save(provider);
    }*/

    public List<Provider> findAll(){
        return providerRepository.findAll();
    }

    public List<Provider> findByServiceName(String searchString){

        List<ServiceDetail> serviceDetailList = serviceRepository.searchService(searchString);

        List<Provider> providerList = new ArrayList<>();
        serviceDetailList.forEach(service ->{
            Provider provider = providerRepository.findByServiceDetailIdService(service.getIdService());

            provider.setServiceDetail(service);

            providerList.add(provider);
        });

        return providerList;
    }
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
