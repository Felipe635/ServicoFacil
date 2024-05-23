package com.example.servicofacil.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicofacil.model.Order;
import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.ServiceDetail;
import com.example.servicofacil.model.User;
import com.example.servicofacil.repository.OrderRepository;
import com.example.servicofacil.repository.ServiceRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(User user, Provider provider) {

        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setProvider(provider);
        //var descricao = serviceRepository.findServiceDescriptionByIdProvider(provider.getIdProvider());
        newOrder.setDescription("teste");
        newOrder.setDtCadastro(new Timestamp(System.currentTimeMillis()));

        return orderRepository.save(newOrder);
    }
}