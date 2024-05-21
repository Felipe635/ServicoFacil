package com.example.servicofacil.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicofacil.model.Order;
import com.example.servicofacil.model.ServiceDetail;
import com.example.servicofacil.model.User;
import com.example.servicofacil.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(User user, ServiceDetail service) {
        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setService(service);
        return orderRepository.save(newOrder);
    }
}