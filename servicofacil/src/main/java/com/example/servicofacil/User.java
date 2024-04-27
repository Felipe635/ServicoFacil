package com.example.servicofacil;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

public class User {

    private @Getter @Setter Long id;

    @NotEmpty(message = "O nome é obrigatório")
    private @Getter @Setter String name;

    @NotEmpty(message = "A senha é obrigatória")
    private @Getter @Setter String password;

    @NotEmpty(message = "O e-mail é obrigatório")
    private @Getter @Setter String email;

    @NotEmpty(message = "O CPF é obrigatório")
    private @Getter @Setter String cpf;

    @NotEmpty(message = "O telefone é obrigatório")
    private @Getter @Setter String phone;

    @NotEmpty(message = "O CEP é obrigatório")
    private @Getter @Setter String zipcode;

    @NotEmpty(message = "O endereço é obrigatório")
    private @Getter @Setter String address;

    @NotEmpty(message = "O bairro é obrigatório")
    private @Getter @Setter String district;

    @NotEmpty(message = "O numero é obrigatório")
    private @Getter @Setter String addressNumber;

}
