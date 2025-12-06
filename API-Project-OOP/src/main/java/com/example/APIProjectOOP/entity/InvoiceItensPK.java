package com.example.APIProjectOOP.entity;

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
public class InvoiceItensPK implements Serializable{
    private static final long serialVersionUID = 1L;

    @Column(name= "InvoiceIdInvoice")
    private Long idinvoice;

    @Column(name= "RegisterProductidProduct")
    private Long idProduct;
}
