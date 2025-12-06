package com.example.API_Project_OOP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_invoice_itens")
@Table(name= "Invoice_itens")
public class Invoice_Itens {
    @EmbeddedId
    private Invoice_Itens_PK id_invoice_itens;

    @ManyToOne
    @MapsId("id_invoice")
    @JoinColumn(name= "Invoice_Id_Invoice")
    private Invoice invoice;

    @ManyToOne
    @MapsId("id_product")
    @JoinColumn(name= "Id_Product")
    private Register_Product register_product;

    @Column(name= "Product_Quantity", nullable= false)
    private int product_quantity;
}
