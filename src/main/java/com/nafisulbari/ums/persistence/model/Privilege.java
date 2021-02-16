package com.nafisulbari.ums.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Entity
@Getter
@Setter
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank
    private String url;

    public Privilege(){}

    public Privilege(Optional<Privilege> optionalPrivilege) {
        optionalPrivilege.ifPresent(p ->{
            this.id = p.getId();
            this.url = p.getUrl();
        });
    }
}
