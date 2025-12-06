package com.example.APIProjectOOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.APIProjectOOP.entity.RegisterClient;

public interface RegisterClientRepository extends JpaRepository<RegisterClient, Long>{
    
}
