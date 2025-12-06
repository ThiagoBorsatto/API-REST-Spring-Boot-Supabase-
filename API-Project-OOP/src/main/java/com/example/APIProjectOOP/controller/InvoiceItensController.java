package com.example.APIProjectOOP.controller;

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
import com.example.APIProjectOOP.entity.InvoiceItens;
import com.example.APIProjectOOP.entity.InvoiceItensPK;
import com.example.APIProjectOOP.repository.InvoiceItensRepository;

@RestController
@RequestMapping("/api/invoiceitens")
public class InvoiceItensController {
    private final InvoiceItensRepository invoiceItensRepository;

    public InvoiceItensController(InvoiceItensRepository repository){
        this.invoiceItensRepository = repository;
    }

    @GetMapping
    public List<InvoiceItens> listInvoiceItens(){
        return invoiceItensRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceItens> findInvoiceItensById(@PathVariable InvoiceItensPK id){
        return invoiceItensRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InvoiceItens createInvoiceItens(@RequestBody InvoiceItens invoiceItens) {
        return invoiceItensRepository.save(invoiceItens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceItens> updateInvoiceItens(@PathVariable InvoiceItensPK id, @RequestBody InvoiceItens invoiceItens) {
        if (!invoiceItensRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoiceItens.setIdinvoiceitens(id);
        return ResponseEntity.ok(invoiceItensRepository.save(invoiceItens));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceItens(@PathVariable InvoiceItensPK id) {
        if (!invoiceItensRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoiceItensRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}