package com.example.API_Project_OOP.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Invoice_Itens_PK implements Serializable{
    private static final long serialVersionUID = 1L;

    @Column(name= "Invoice_Id_Invoice")
    private Long id_invoice;

    @Column(name= "Register_Product_Id_Product")
    private Long id_product;
}
