package com.example.cryptoworld.service;

import com.example.cryptoworld.models.entities.RoleEntity;

public interface RoleService {
    void InitRoleInDb();
    RoleEntity  getRole(Long id);
    RoleEntity findByRoleName(String roleName);
}
