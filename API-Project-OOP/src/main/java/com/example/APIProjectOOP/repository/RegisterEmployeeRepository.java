package com.example.APIProjectOOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.APIProjectOOP.entity.RegisterEmployee;

public interface RegisterEmployeeRepository extends JpaRepository<RegisterEmployee, Long>{
    
}
