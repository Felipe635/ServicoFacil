package com.example.servicofacil.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicofacil.model.Order;
import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.ServiceDetail;
import com.example.servicofacil.model.User;
import com.example.servicofacil.repository.OrderRepository;
import com.example.servicofacil.repository.ProviderRepository;
import com.example.servicofacil.repository.ServiceRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ProviderRepository providerRepository;

    public Order createOrder(User user, Provider provider) {

        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setProvider(provider);
        Provider idProvider = providerRepository.findByIdProvider(provider.getIdProvider()) ;
        var idService = serviceRepository.findByIdProvider(idProvider);
        //var descricao = serviceRepository.findServiceDescriptionByIdProvider(provider.getIdProvider());
        newOrder.setDescription(idService.getServiceDescription());
        newOrder.setServiceValue(idService.getServiceValue());
        newOrder.setDtCadastro(new Timestamp(System.currentTimeMillis()));

        return orderRepository.save(newOrder);
    }

    public List<Order> findAllOrders() {

        return orderRepository.findAll();
    }
}