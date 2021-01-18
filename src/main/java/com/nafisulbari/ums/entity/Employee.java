package com.nafisulbari.ums.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int employeeId;
    private String firstName;
    private String lastName;
    private String company;
    private String department;
    private String designation;
    private String workLocation;
    private String email;
    private String mobile;
    private String extension;
    private String role;
    private String status;



    public Employee() {
    }
}
