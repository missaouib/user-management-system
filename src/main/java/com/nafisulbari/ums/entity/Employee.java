package com.nafisulbari.ums.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int employeeId;
    @NotNull
    @Size(min = 1, max = 5, message = "size should be 1 < size < 6")
    private String firstName;
    @Size(min = 8, max = 15)
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
