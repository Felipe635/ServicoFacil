package com.example.servicofacil.repository;

import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    
    Provider findByLogin(String login);
    //List<Provider> findByLoginList(List<Provider> login);
}
