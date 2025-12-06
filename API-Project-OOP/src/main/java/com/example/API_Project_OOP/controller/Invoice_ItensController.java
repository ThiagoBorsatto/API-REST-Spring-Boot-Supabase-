package com.example.API_Project_OOP.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.API_Project_OOP.entity.Invoice_Itens;
import com.example.API_Project_OOP.entity.Invoice_Itens_PK;
import com.example.API_Project_OOP.repository.Invoice_ItensRepository;

@RestController
@RequestMapping("/api/Invoice_Itens")
public class Invoice_ItensController {
    private final Invoice_ItensRepository invoice_ItensRepository;

    public Invoice_ItensController(Invoice_ItensRepository repository){
        this.invoice_ItensRepository = repository;
    }

    @GetMapping
    public List<Invoice_Itens> listInvoice_Itens(){
        return invoice_ItensRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice_Itens> findInvoice_ItensById(@PathVariable Invoice_Itens_PK id){
        return invoice_ItensRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Invoice_Itens createInvoice_Itens(@RequestBody Invoice_Itens invoice_Itens) {
        return invoice_ItensRepository.save(invoice_Itens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice_Itens> updateInvoice_Itens(@PathVariable Invoice_Itens_PK id, @RequestBody Invoice_Itens invoice_Itens) {
        if (!invoice_ItensRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoice_Itens.setId_invoice_itens(id);
        return ResponseEntity.ok(invoice_ItensRepository.save(invoice_Itens));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice_Itens(@PathVariable Invoice_Itens_PK id) {
        if (!invoice_ItensRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoice_ItensRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}