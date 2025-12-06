package com.example.API_Project_OOP.entity;

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
@EqualsAndHashCode(of = "id_client")
@Table(name= "Register_Client")
public class Register_Client {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "Id_Client")
    private Long id_client;

    @Column(name= "Client_Name", length= 100, nullable= false)
    private String client_name;

    @Column(name= "Client_Adress", length= 100, nullable= false)
    private String client_adress;

    @Column(name= "Client_Phone", length= 100, nullable= false)
    private String client_phone;

    @Column(name= "Client_Email", length= 100, nullable= false)
    private String client_email;
}
