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
import com.example.APIProjectOOP.entity.RegisterClient;
import com.example.APIProjectOOP.repository.RegisterClientRepository;

@RestController
@RequestMapping("/api/registerclient")
public class RegisterClientController {
    private final RegisterClientRepository clientRepository;

    public RegisterClientController(RegisterClientRepository repository){
        this.clientRepository = repository;
    }

    @GetMapping
    public List<RegisterClient> listClient(){
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisterClient> findClientById(@PathVariable Long id){
        return clientRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RegisterClient createClient(@RequestBody RegisterClient client) {
        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterClient> updateclient(@PathVariable Long id, @RequestBody RegisterClient client) {
        if (!clientRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        client.setIdclient(id);
        return ResponseEntity.ok(clientRepository.save(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (!clientRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}