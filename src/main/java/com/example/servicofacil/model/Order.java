package com.example.servicofacil.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;


import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "requestOrder")  
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

