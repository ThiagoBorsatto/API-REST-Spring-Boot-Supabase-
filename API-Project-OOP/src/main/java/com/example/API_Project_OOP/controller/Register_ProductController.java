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
import com.example.API_Project_OOP.entity.Register_Product;
import com.example.API_Project_OOP.repository.Register_ProductRepository;

@RestController
@RequestMapping("/api/Register_Product")
public class Register_ProductController {
    private final Register_ProductRepository productRepository;

    public Register_ProductController(Register_ProductRepository repository){
        this.productRepository = repository;
    }

    @GetMapping
    public List<Register_Product> listProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Register_Product> findProductById(@PathVariable Long id){
        return productRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Register_Product createProduct(@RequestBody Register_Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Register_Product> updateProduct(@PathVariable Long id, @RequestBody Register_Product product) {
        if (!productRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        product.setId_product(id);
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
