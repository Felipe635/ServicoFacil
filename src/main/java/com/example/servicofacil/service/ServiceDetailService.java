package com.example.servicofacil.service;

import com.example.servicofacil.model.ServiceDetail;
import com.example.servicofacil.repository.ProviderRepository;
import com.example.servicofacil.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDetailService {

    @Autowired
    private ServiceRepository serviceRepository;
    
    @Autowired
    private ProviderRepository providerRepository;

    public ServiceDetail findById(Long id) {
        var idService = serviceRepository.findByIdService(id);

        return idService;
    }

        
/*    public void serviceSave(ServiceDetail serviceDetail) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Provider provider = providerRepository.findByLogin(username);
        
        ServiceDetail novoServico = new ServiceDetail();
        novoServico.setServiceDescription(serviceDetail.getServiceDescription());
        novoServico.setServiceValue(serviceDetail.getServiceValue());
        novoServico.setProvider(provider);
        //novoServico.setDtCadastro(LocalDateTime.now());
        
        serviceRepository.save(novoServico);
    }*/
}
