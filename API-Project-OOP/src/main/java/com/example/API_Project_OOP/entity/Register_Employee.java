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
@EqualsAndHashCode(of = "id_employee")
@Table(name= "Register_Employee")
public class Register_Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "Id_Employee")
    private long id_employee;

    @Column(name= "Employee_Name", length= 100, nullable= false)
    private String employee_name;

    @Column(name= "Employee_Adress", length= 100, nullable= false)
    private String employee_adress;

    @Column(name= "Employee_Phone", length= 100, nullable= false)
    private String employee_phone;

    @Column(name= "Employee_Email", length= 100, nullable= false)
    private String employee_email;
}
