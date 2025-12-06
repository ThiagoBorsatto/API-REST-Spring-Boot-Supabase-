package com.example.API_Project_OOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API_Project_OOP.entity.Invoice_Itens;
import com.example.API_Project_OOP.entity.Invoice_Itens_PK;

public interface Invoice_ItensRepository extends JpaRepository<Invoice_Itens, Invoice_Itens_PK>{ 
}
