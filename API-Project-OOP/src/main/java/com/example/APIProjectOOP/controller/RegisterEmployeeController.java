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
import com.example.APIProjectOOP.entity.RegisterEmployee;
import com.example.APIProjectOOP.repository.RegisterEmployeeRepository;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/registeremployee")
public class RegisterEmployeeController {
    private final RegisterEmployeeRepository employeeRepository;

    public RegisterEmployeeController(RegisterEmployeeRepository repository){
        this.employeeRepository = repository;
    }

    @GetMapping
    public List<RegisterEmployee> listEmployee(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisterEmployee> findEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RegisterEmployee createEmployee(@RequestBody RegisterEmployee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterEmployee> updateEmployee(@PathVariable Long id, @RequestBody RegisterEmployee employee) {
        if (!employeeRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        employee.setIdemployee(id);
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!employeeRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
