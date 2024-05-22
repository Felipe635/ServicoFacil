package com.example.servicofacil.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.servicofacil.model.ServiceDetail;


@Repository
public interface ServiceRepository extends JpaRepository<ServiceDetail, Long> {
    

    ServiceDetail findByIdService(Long id_service);

}
