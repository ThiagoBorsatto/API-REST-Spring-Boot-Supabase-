package com.example.API_Project_OOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API_Project_OOP.entity.Register_Employee;

public interface Register_EmployeeRepository extends JpaRepository<Register_Employee, Long>{
    
}
