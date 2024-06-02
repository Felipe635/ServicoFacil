package com.example.servicofacil.controller;

import com.example.servicofacil.model.Order;
import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.User;
import com.example.servicofacil.service.OrderService;
import com.example.servicofacil.service.ProviderService;
import com.example.servicofacil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProviderService providerService;

 @PostMapping("/createOrder")
    public String createOrder(Model model) {
        try {
/*
            User user = userService.findUserById(orderRequest.getUserId());
*/
            User user = userService.findUserById(Long.valueOf(1));
/*
            Provider provider = providerService.findProviderById(orderRequest.getIdProvider());
*/
            Provider provider = providerService.findProviderById(Long.valueOf(1));


            Order order = orderService.createOrder(user, provider);
            model.addAttribute("order", order);

            return "client-dashboard";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

     /**
     * Recupera todos os pedidos existentes no sistema.
     * Retorna uma lista de pedidos ou um erro se não puder recuperá-los.
     */
    @GetMapping("/getAllOrders")
    public @ResponseBody ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orders = orderService.findAllOrders();
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
