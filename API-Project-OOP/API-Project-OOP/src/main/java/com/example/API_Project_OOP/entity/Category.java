package com.example.API_Project_OOP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id_category")
@Table(name= "Category")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "Id_Category")
    private long id_category;

    @Column(name= "Category_Description", length= 100, nullable= false)
    private String category_description;

    public Category() {
    }

    public Category(String category_description, long id_category) {
        this.category_description = category_description;
        this.id_category = id_category;
    }
}
