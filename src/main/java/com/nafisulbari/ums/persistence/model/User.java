package com.nafisulbari.ums.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@Table(name = "user_account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Digits(integer = 6, fraction = 0, message = "Must be a 6 digit number")
    private int userId;

    @NotEmpty
    @Pattern(regexp = "^[ A-Za-z]+$", message = "Only letters and spaces are allowed")
    private String firstName;

    @NotEmpty
    private String password;

    @NotEmpty
    @Pattern(regexp = "^[ A-Za-z]+$", message = "Only letters and spaces are allowed")
    private String lastName;

    @NotEmpty
    private String company;

    @NotEmpty
    private String department;

    @NotEmpty
    private String designation;

    @NotEmpty
    private String workLocation;

    @Email
    @NotEmpty
    private String email;

    @Digits(integer = 11, fraction = 0, message = "Only 11 digit numbers are allowed")
    private int mobile;

    private String extension;

    @NotEmpty
    @DateTimeFormat
    private String joiningDate;

    @OneToMany(mappedBy = "user")
    private List<UserToRole> userToRoles;

    @NotNull(message = "Value can be either true or false")
    private boolean active;


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
            this.active = e.isActive();
            this.userToRoles = e.getUserToRoles();

        });
    }
}
