package com.example.servicofacil.controller;

import com.example.servicofacil.model.Order;
import com.example.servicofacil.model.ServiceDetail;
import com.example.servicofacil.model.User;
import com.example.servicofacil.service.OrderService;
import com.example.servicofacil.service.ServiceDetailService;
import com.example.servicofacil.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceDetailService serviceDetailService;

    //@PostMapping("/createOrder")
    //public Order createOrder(@RequestBody OrderRequest orderRequest) {
    //    User user = userService.findUserById(orderRequest.getUserId());
    //    Optional<ServiceDetail> service = serviceDetailService.findById(orderRequest.getIdService());
    //    return orderService.createOrder(user, service);
    //}
}

class OrderRequest {
    private Long UserId;
    private Long idService;

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }
}
