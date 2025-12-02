package com.example.API_Project_OOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API_Project_OOP.entity.Register_Client;

public interface Register_ClientRepository extends JpaRepository<Register_Client, Long>{
    
}
