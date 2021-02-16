package com.nafisulbari.ums.persistence.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "role")
    private List<RoleToPrivilege> roleToPrivileges;



    public Role(){}
    public Role(Optional<Role> optionalRole) {
        optionalRole.ifPresent(r -> {
            this.id = r.getId();
            this.name = r.getName();
            this.roleToPrivileges = r.getRoleToPrivileges();
        });
    }


}
