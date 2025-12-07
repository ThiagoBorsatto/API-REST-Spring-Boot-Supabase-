package com.example.APIProjectOOP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.APIProjectOOP.entity.Category;

public interface  CategoryRepository extends JpaRepository<Category, Long>{
    
}
