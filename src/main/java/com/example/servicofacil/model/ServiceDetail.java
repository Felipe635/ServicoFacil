package com.example.servicofacil.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class ServiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    private Long idService;

    @ManyToOne
    @JoinColumn(name = "id_provider", referencedColumnName = "id_provider")
    private Provider idProvider;
    
    @Column(name = "service_description")
    private String serviceDescription;

    @Column(name = "service_value")
    private double serviceValue;

    @CreationTimestamp
    @Column(name = "dt_cadastro", nullable = false, updatable = false)
    private LocalDateTime dtCadastro;

    @Column(name = "service_name")
    private String serviceName;

    //@JsonManagedReference
    //@OneToMany(mappedBy = "serviceDetail", fetch = FetchType.LAZY)
    //private Set<Provider> providers = new HashSet<>();
}
