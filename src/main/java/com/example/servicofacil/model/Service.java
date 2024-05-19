package com.example.servicofacil.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Service {

    @Id
    @Column(name = "id_service")
    private Integer idService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provider")
    private Provider provider;

    @Column(name = "service_value")
    private String serviceValue;

    @Column(name = "dt_cadastro")
    private Timestamp dtCadastro;
}
