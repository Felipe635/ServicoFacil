package com.example.servicofacil.repository;

import com.example.servicofacil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    @Query("SELECT u FROM users u JOIN FETCH u.roles WHERE u.login = :login")
    User findByLoginFetchRoles(@Param("login") String login);
}

