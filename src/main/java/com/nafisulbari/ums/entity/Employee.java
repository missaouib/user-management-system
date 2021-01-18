package com.nafisulbari.ums.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
    @Length(min = 1, max = 5, message = "length should be less than 6 and greater than 0")
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
