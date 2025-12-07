package com.example.APIProjectOOP.entity;

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
@EqualsAndHashCode(of = "idinvoiceitens")
@Table(name= "Invoiceitens")
public class InvoiceItens {
    @EmbeddedId
    private InvoiceItensPK idinvoiceitens;

    @ManyToOne
    @MapsId("idinvoice")
    @JoinColumn(name= "idinvoice")
    private Invoice invoice;

    @ManyToOne
    @MapsId("idproduct")
    @JoinColumn(name= "idproduct")
    private RegisterProduct registerproduct;

    @Column(name= "ProductQuantity", nullable= false)
    private Long productquantity;
}
