package com.example.API_Project_OOP.entity;

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
@EqualsAndHashCode(of = "id_invoice")
@Table(name= "Invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "Id_Invoice")
    private Long id_invoice;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "Register_Client_Id_Client", nullable= false)
    private Register_Client register_client;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "Register_Employee_Id_Employee", nullable= false)
    private Register_Employee register_employee;

    @Column(name= "Emission_Date")
    private LocalDate emission_date;

    @Column(name= "Invoice_Value", precision= 10, scale= 2, nullable=false)
    private BigDecimal invoice_value;

    @OneToMany(mappedBy= "invoice", cascade= CascadeType.ALL, orphanRemoval= true)
    private Set<Invoice_Itens> itens = new HashSet<>();
}
