package com.nafisulbari.ums.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @Digits(integer = 6, fraction = 0, message = "Must be a 6 digit number")
    private int userId;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[ A-Za-z]+$", message = "Only letters and spaces are allowed")
    private String firstName;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[ A-Za-z]+$", message = "Only letters and spaces are allowed")
    private String lastName;

    @NotNull
    @NotEmpty
    private String company;

    @NotNull
    @NotEmpty
    private String department;

    @NotNull
    @NotEmpty
    private String designation;

    @NotNull
    @NotEmpty
    private String workLocation;

    @NotNull
    @Email
    @NotEmpty
    private String email;

    @NotNull
    @Digits(integer = 11, fraction = 0, message = "Only 11 digit numbers are allowed")
    private int mobile;

    private String extension;

    @NotNull
    @NotEmpty
    @DateTimeFormat
    private String joiningDate;

    @ManyToMany
    private Set<Role> roles;

    @NotNull
    @NotEmpty
    private String status;


    public User() {
    }

    public User(Optional<User> optionalUser) {
        optionalUser.ifPresent(e -> {
            this.id = e.getId();
            this.userId = e.getUserId();
            this.firstName = e.getFirstName();
            this.lastName = e.getLastName();
            this.password = e.getPassword();
            this.company = e.getCompany();
            this.department = e.getDepartment();
            this.designation = e.getDesignation();
            this.email = e.getEmail();
            this.workLocation = e.getWorkLocation();
            this.extension = e.getExtension();
            this.joiningDate = e.getJoiningDate();
            this.mobile = e.getMobile();
            this.status = e.getStatus();
            this.roles = e.getRoles();

        });
    }
}
