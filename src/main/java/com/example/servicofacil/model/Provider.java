package com.example.servicofacil.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_provider")
    private Integer idProvider;

    @Column(name = "address")
    private String address;

    @Column(name = "address_number")
    private String addressNumber;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "district")
    private String district;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "username")
    private String username;

    @Column(name = "zipcode")
    private String zipcode;

    @OneToOne
    @JoinColumn(name = "id_provider")
    @JsonBackReference
    private ServiceDetail serviceDetail;
}