package com.example.servicofacil.controller;

import com.example.servicofacil.model.Order;
import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.User;
import com.example.servicofacil.requestModel.OrderRequest;
import com.example.servicofacil.service.OrderService;
import com.example.servicofacil.service.ProviderService;
import com.example.servicofacil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            User user = userService.findUserById(orderRequest.getUserId());
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }


            Provider provider = providerService.findProviderById(orderRequest.getIdProvider());
            if (provider == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Provider not found");
            }



            Order order = orderService.createOrder(user, provider);

            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order");
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
