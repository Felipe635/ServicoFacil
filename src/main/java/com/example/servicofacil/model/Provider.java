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
@Table(name = "provider")
public class Provider {

    @Id
    @Column(name = "id_provider")
    private Integer idProvider;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "phone")
    private String phone;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "addressNumber")
    private String addressNumber;

    @Column(name = "dateCreated")
    private Timestamp dateCreated;
}
