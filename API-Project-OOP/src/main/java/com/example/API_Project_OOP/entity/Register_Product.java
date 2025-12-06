package com.example.API_Project_OOP.entity;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id_product")
@Table(name = "Register_Product")
public class Register_Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "Id_Product")
    private Long id_product;

    @Column(name= "Description", length= 100, nullable= false)
    private String description;

    @Column(name= "Product_Value", precision= 10, scale= 2, nullable=false)
    private BigDecimal product_value;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "Category_Id_Category", nullable= false)
    private Category id_category;

    public Register_Product() {
    }

    public Register_Product(Category id_category, String description, BigDecimal product_value) {
        this.id_category = id_category;
        this.description = description;
        this.product_value = product_value;
    }
}
