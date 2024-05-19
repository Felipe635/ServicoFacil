package com.example.servicofacil.repository;

import com.example.servicofacil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getUserByLoginAndPassword(String login, String password);
}

