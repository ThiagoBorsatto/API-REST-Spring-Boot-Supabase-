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
@EqualsAndHashCode(of = "idemployee")
@Table(name= "RegisterEmployee")
public class RegisterEmployee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "IdEmployee")
    private Long idemployee;

    @Column(name= "EmployeeName", length= 100, nullable= false)
    private String employeename;

    @Column(name= "EmployeeAdress", length= 100, nullable= false)
    private String employeeadress;

    @Column(name= "EmployeePhone", length= 100, nullable= false)
    private String employeephone;

    @Column(name= "EmployeeEmail", length= 100, nullable= false)
    private String employeeemail;
}
