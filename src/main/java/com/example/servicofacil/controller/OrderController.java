package com.example.servicofacil.controller;

import com.example.servicofacil.model.Order;
import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.User;
import com.example.servicofacil.service.OrderService;
import com.example.servicofacil.service.ProviderService;
import com.example.servicofacil.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProviderService providerService;

    /**
     * Cria um pedido com base nos dados recebidos no corpo da requisição.
     * Verifica se o usuário e o prestador existem antes de criar o pedido.
     * orderRequest Contém os dados do usuário e do serviço solicitado.
     * Retorna o pedido criado ou uma mensagem de erro se algo falhar.
     */
 @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            User user = userService.findUserById(orderRequest.getUserId());
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }


            Provider provider = providerService.findProviderById(orderRequest.getIdService());
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
