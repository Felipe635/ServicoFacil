package com.example.servicofacil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.servicofacil.model.Order;
import com.example.servicofacil.model.Provider;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
