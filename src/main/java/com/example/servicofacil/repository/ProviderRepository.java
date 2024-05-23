package com.example.servicofacil.repository;

import com.example.servicofacil.model.Provider;
import com.example.servicofacil.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    
/*    Provider findByLogin(String login);
    //List<Provider> findByLoginList(List<Provider> login);*/

/*
    @Query("select p from provider p WHERE id_service = :id_service")
    Provider findByIdService(@Param("id_service") long id_service);
*/

/*    @Query("select p from provider p where p.id_service = (select id_service from service where id_service = :id_service)")
    Provider findByIdService(@Param("id_service") long id_service);*/
    Provider findByServiceDetailIdService(Long id_service);
    
    Provider findProviderByIdProvider(Long id);

}
