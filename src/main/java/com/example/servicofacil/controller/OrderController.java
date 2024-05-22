package com.example.servicofacil.controller;

import com.example.servicofacil.model.Order;
import com.example.servicofacil.model.ServiceDetail;
import com.example.servicofacil.model.User;
import com.example.servicofacil.service.OrderService;
import com.example.servicofacil.service.ServiceDetailService;
import com.example.servicofacil.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceDetailService serviceDetailService;

 @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            User user = userService.findUserById(orderRequest.getUserId());
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }

            ServiceDetail service = serviceDetailService.findById(orderRequest.getIdService());
            if (service == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
            }

            Order order = orderService.createOrder(user, service);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order");
        }
    }
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
