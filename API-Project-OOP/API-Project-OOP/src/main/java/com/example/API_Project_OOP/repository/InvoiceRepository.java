package com.example.API_Project_OOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API_Project_OOP.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
}
