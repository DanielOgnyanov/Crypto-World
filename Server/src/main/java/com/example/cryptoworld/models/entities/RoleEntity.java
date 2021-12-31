package com.example.cryptoworld.models.entities;


import com.example.cryptoworld.models.enums.EnumRole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{

    private EnumRole role;


    public RoleEntity() {
    }

    public RoleEntity(EnumRole role) {
        this.role = role;
    }

    @Enumerated(EnumType.STRING)
    public EnumRole getRole() {
        return role;
    }

    public void setRole(EnumRole role) {
        this.role = role;
    }


}
