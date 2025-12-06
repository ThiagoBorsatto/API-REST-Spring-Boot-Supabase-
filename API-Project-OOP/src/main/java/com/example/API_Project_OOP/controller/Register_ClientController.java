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
import com.example.API_Project_OOP.entity.Register_Client;
import com.example.API_Project_OOP.repository.Register_ClientRepository;

@RestController
@RequestMapping("/api/Register_Client")
public class Register_ClientController {
    private final Register_ClientRepository clientRepository;

    public Register_ClientController(Register_ClientRepository repository){
        this.clientRepository = repository;
    }

    @GetMapping
    public List<Register_Client> listClient(){
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Register_Client> findClientById(@PathVariable Long id){
        return clientRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Register_Client createClient(@RequestBody Register_Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Register_Client> updateclient(@PathVariable Long id, @RequestBody Register_Client client) {
        if (!clientRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        client.setId_client(id);
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