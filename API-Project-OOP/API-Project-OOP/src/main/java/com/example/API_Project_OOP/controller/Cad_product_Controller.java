package com.example.API_Project_OOP.controller;


import com.example.API_Project_OOP.entity.Cad_product;
import com.example.API_Project_OOP.repository.Cad_productRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cad_product")
public class Cad_product_Controller {

    private final Cad_productRepository repository;

    public Cad_product_Controller(Cad_productRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Cad_product> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cad_product> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cad_product criar(@RequestBody Cad_product produto) {
        return repository.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cad_product> atualizar(@PathVariable Long id, @RequestBody Cad_product produto) {
        if (!repository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produto.setId(id);
        return ResponseEntity.ok(repository.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
