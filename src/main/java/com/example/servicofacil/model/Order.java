package com.example.servicofacil.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;


import jakarta.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "requestOrder")  
public class Order {

    @Id
    @Column(name = "id_order")
    private Integer idOrder;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_service")
    private ServiceDetail service;

    @Column(name = "dt_cadastro")
    private Timestamp dtCadastro;
}

