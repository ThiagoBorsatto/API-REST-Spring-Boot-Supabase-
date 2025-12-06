package com.example.APIProjectOOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.APIProjectOOP.entity.InvoiceItens;
import com.example.APIProjectOOP.entity.InvoiceItensPK;

public interface InvoiceItensRepository extends JpaRepository<InvoiceItens, InvoiceItensPK>{ 
}
