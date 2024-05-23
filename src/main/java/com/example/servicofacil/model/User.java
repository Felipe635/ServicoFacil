package com.example.servicofacil.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idUser;

    @NotEmpty(message = "O login é obrigatório")
    @Column(name = "login", unique = true)
    private String login;

    @NotEmpty(message = "A senha é obrigatória")
    @Column(name = "password")
    private String password;

    @NotEmpty(message = "O e-mail é obrigatório")
    private @Setter String email;

    @NotEmpty(message = "O CPF é obrigatório")
    private @Setter String cpf;

    @NotEmpty(message = "O telefone é obrigatório")
    private @Setter String phone;

    @NotEmpty(message = "O CEP é obrigatório")
    private @Setter String zipcode;

    @NotEmpty(message = "O endereço é obrigatório")
    private @Setter String address;
    
    @NotEmpty(message = "O numero é obrigatório")
    private @Setter String addressNumber;

    @NotEmpty(message = "O bairro é obrigatório")
    private @Setter String district;

    @ManyToMany
    private List<Role> roles;

}