package com.example.APIProjectOOP.entity;

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
@EqualsAndHashCode(of = "idProduct")
@Table(name = "RegisterProduct")
public class RegisterProduct {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "idProduct")
    private Long idProduct;

    @Column(name= "Description", length= 100, nullable= false)
    private String description;

    @Column(name= "ProductValue", precision= 10, scale= 2, nullable=false)
    private BigDecimal productvalue;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "CategoryIdCategory", nullable= false)
    private Category idcategory;

    public RegisterProduct() {
    }

    public RegisterProduct(Category idcategory, String description, BigDecimal productvalue) {
        this.idcategory = idcategory;
        this.description = description;
        this.productvalue = productvalue;
    }
}
