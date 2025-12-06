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
import com.example.API_Project_OOP.entity.Invoice;
import com.example.API_Project_OOP.repository.InvoiceRepository;

@RestController
@RequestMapping("/api/Invoice")
public class InvoiceController {
    private final InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository repository){
        this.invoiceRepository = repository;
    }

    @GetMapping
    public List<Invoice> listInvoice(){
        return invoiceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> findInvoiceById(@PathVariable Long id){
        return invoiceRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateinvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        if (!invoiceRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoice.setId_invoice(id);
        return ResponseEntity.ok(invoiceRepository.save(invoice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        if (!invoiceRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoiceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}