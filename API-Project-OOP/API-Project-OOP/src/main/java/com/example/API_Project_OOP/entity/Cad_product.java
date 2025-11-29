package com.example.API_Project_OOP.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cad_product")
public class Cad_product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoria;
    private String descricao;
    private Double valor_produto;

    public Cad_product() {
    }

    public Cad_product(int id, String categoria, String descricao, Double valor_produto) {
        this.id = id;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor_produto = valor_produto;
    }
}
