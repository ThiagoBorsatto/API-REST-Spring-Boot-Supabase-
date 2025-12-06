package com.example.APIProjectOOP.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@EqualsAndHashCode(of = "idinvoice")
@Table(name= "Invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "IdInvoice")
    private Long idinvoice;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "RegisterClientIdClient", nullable= false)
    private RegisterClient registerclient;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "RegisterEmployeeIdEmployee", nullable= false)
    private RegisterEmployee registeremployee;

    @Column(name= "EmissionDate")
    private LocalDate emissiondate;

    @Column(name= "InvoiceValue", precision= 10, scale= 2, nullable=false)
    private BigDecimal invoicevalue;

    @OneToMany(mappedBy= "invoice", cascade= CascadeType.ALL, orphanRemoval= true)
    private Set<InvoiceItens> itens = new HashSet<>();
}
