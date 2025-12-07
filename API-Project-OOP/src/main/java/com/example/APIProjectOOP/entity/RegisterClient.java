package com.example.APIProjectOOP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@EqualsAndHashCode(of = "idclient")
@Table(name= "RegisterClient")
public class RegisterClient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "IdClient")
    private Long idclient;

    @Column(name= "ClientName", length= 100, nullable= false)
    private String clientname;

    @Column(name= "ClientAdress", length= 100, nullable= false)
    private String clientadress;

    @Column(name= "ClientPhone", length= 100, nullable= false)
    private String clientphone;

    @Column(name= "ClientEmail", length= 100, nullable= false)
    private String clientemail;
}
