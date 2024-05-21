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
    private Long id;

    @NotEmpty(message = "O login é obrigatório")
    @Column(name = "login", unique = true)
    private String login;

    @NotEmpty(message = "A senha é obrigatória")
    @Column(name = "password")
    private String password;

    @ManyToMany
    private List<Role> roles;

}