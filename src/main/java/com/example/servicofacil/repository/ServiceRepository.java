package com.example.servicofacil.repository;

import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.ServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ServiceRepository extends JpaRepository<ServiceDetail, Long> {
    

    ServiceDetail findByIdService(Long id_service);
    
    ServiceDetail findByIdProvider(Provider provider);

    //@Query("SELECT s.service_description FROM service s WHERE s.id_provider = :idProvider")
    //ServiceDetail findServiceDescriptionByIdProvider(@Param("idProvider") Long idProvider);


    @Query("SELECT s FROM ServiceDetail s WHERE s.serviceName LIKE %:searchTerm%")
    List<ServiceDetail> searchService(@Param("searchTerm") String searchTerm);

}
