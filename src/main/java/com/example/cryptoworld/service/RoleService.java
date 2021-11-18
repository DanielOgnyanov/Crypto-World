package com.example.cryptoworld.service;

import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.enums.EnumRole;

public interface RoleService {
    void InitRoleInDb();
    RoleEntity  getRole(Long id);
}
