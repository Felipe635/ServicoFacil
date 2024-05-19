package com.example.servicofacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Setter Long id;

    @NotEmpty(message = "O nome é obrigatório")
    private @Setter String login;

    @NotEmpty(message = "A senha é obrigatória")
    private @Setter String password;

    private @Setter String role;
}
