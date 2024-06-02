/*
package com.example.servicofacil.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DataInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insere dados iniciais
        insertUserData();
    }

    private void insertUserData() {
        String sql = "INSERT INTO users (login, password) VALUES (?, ?)";

        // Criptografando a senha usando BCryptPasswordEncoder
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Senhas originais (antes de criptografar)
        String passwordAdmin = "admin";
        String passwordUser2 = "user2";

        // Criptografando as senhas
        String hashedPasswordAdmin = encoder.encode(passwordAdmin);
        String hashedPasswordUser2 = encoder.encode(passwordUser2);

        // Inserindo usuários de exemplo
        jdbcTemplate.update(sql, "admin", hashedPasswordAdmin);
        jdbcTemplate.update(sql, "user2", hashedPasswordUser2);

        System.out.println("Dados inseridos com sucesso!");
    }
}*/
