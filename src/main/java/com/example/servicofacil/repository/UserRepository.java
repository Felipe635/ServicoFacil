package com.example.servicofacil.repository;

import com.example.servicofacil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
