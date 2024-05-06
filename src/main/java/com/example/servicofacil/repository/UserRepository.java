package com.example.servicofacil.repository;

import com.example.servicofacil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Consulta personalizada para encontrar usuários por nome
    @Query("SELECT u FROM users u WHERE u.name = ?1 AND u.password = ?2")
    List<User> getUserByLogin(String name, String password);
}
