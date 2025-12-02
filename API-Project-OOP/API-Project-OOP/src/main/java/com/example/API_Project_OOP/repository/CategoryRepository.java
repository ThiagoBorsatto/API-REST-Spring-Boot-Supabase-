package com.example.API_Project_OOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API_Project_OOP.entity.Category;

public interface  CategoryRepository extends JpaRepository<Category, Long>{
    
}
