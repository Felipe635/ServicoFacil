package com.example.servicofacil.service;

import com.example.servicofacil.model.Order;
import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.User;
import com.example.servicofacil.repository.OrderRepository;
import com.example.servicofacil.repository.ProviderRepository;
import com.example.servicofacil.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        newOrder.setDescription(provider.getServiceDetail().getServiceDescription());
        newOrder.setServiceValue(provider.getServiceDetail().getServiceValue());

        return orderRepository.save(newOrder);
    }

    public List<Order> findAllOrders() {

        return orderRepository.findAll();
    }
}