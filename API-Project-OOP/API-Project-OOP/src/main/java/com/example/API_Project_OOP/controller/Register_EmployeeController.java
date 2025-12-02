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
import com.example.API_Project_OOP.entity.Register_Employee;
import com.example.API_Project_OOP.repository.Register_EmployeeRepository;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/Register_Employee")
public class Register_EmployeeController {
    private final Register_EmployeeRepository employeeRepository;

    public Register_EmployeeController(Register_EmployeeRepository repository){
        this.employeeRepository = repository;
    }

    @GetMapping
    public List<Register_Employee> listEmployee(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Register_Employee> findEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Register_Employee createEmployee(@RequestBody Register_Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Register_Employee> updateEmployee(@PathVariable Long id, @RequestBody Register_Employee employee) {
        if (!employeeRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        employee.setId_employee(id);
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
