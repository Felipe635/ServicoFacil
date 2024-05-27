package com.example.servicofacil.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "request_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_provider")
    private Provider provider;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "service_value")
    private Double serviceValue;

    @Column(name = "dt_cadastro")
    private Timestamp dtCadastro;
}

