package com.nafisulbari.ums.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Employee> employees;


    public Role(){}
    public Role(Optional<Role> optionalRole) {
        optionalRole.ifPresent(r -> {
            this.id = r.getId();
            this.name = r.getName();
        });
    }


}
