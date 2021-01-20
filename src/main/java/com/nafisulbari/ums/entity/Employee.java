package com.nafisulbari.ums.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @Digits(integer = 6, fraction = 0, message = "Must be a 6 digit number")
    private int employeeId;

    @NotNull
    @Pattern(regexp = "^[ A-Za-z]+$", message = "Only letters and spaces are allowed")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[ A-Za-z]+$", message = "Only letters and spaces are allowed")
    private String lastName;

    @NotNull
    private String company;

    @NotNull
    private String department;

    @NotNull
    private String designation;

    @NotNull
    private String workLocation;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Digits(integer = 11, fraction = 0, message = "Only 11 digit numbers are allowed")
    private int mobile;

    private String extension;

    @NotNull
    @DateTimeFormat
    private String joiningDate;

    @NotNull
    private String role;

    @NotNull
    private String status;



    public Employee() {
    }
}
