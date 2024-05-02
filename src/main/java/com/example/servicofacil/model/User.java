package com.example.servicofacil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    private @Setter Long id;

    @NotEmpty(message = "O nome é obrigatório")
    private @Setter String name;

    @NotEmpty(message = "A senha é obrigatória")
    private @Setter String password;

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

    @NotEmpty(message = "O bairro é obrigatório")
    private @Setter String district;

    @NotEmpty(message = "O numero é obrigatório")
    private @Setter String addressNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(cpf, user.cpf) && Objects.equals(phone, user.phone) && Objects.equals(zipcode, user.zipcode) && Objects.equals(address, user.address) && Objects.equals(district, user.district) && Objects.equals(addressNumber, user.addressNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, email, cpf, phone, zipcode, address, district, addressNumber);
    }
}
