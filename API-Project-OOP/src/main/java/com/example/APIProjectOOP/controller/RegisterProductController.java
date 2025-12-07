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
import com.example.APIProjectOOP.entity.RegisterProduct;
import com.example.APIProjectOOP.repository.RegisterProductRepository;

@RestController
@RequestMapping("/api/registerproduct")
public class RegisterProductController {
    private final RegisterProductRepository productRepository;

    public RegisterProductController(RegisterProductRepository repository){
        this.productRepository = repository;
    }

    @GetMapping
    public List<RegisterProduct> listProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisterProduct> findProductById(@PathVariable Long id){
        return productRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RegisterProduct createProduct(@RequestBody RegisterProduct product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterProduct> updateProduct(@PathVariable Long id, @RequestBody RegisterProduct product) {
        if (!productRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        product.setIdProduct(id);
        return ResponseEntity.ok(productRepository.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (!productRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
