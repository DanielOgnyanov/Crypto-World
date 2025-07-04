package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.enums.EnumRole;
import com.example.cryptoworld.repository.RoleRepository;
import com.example.cryptoworld.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void InitRoleInDb() {

        if(roleRepository.count() == 0) {

            Arrays.stream(EnumRole.values())
                    .forEach(currentRole -> {

                        RoleEntity roleEntity = new RoleEntity(currentRole);

                        roleRepository.save(roleEntity);
                    });


        }
    }

    @Override
    public RoleEntity getRole(Long id) {
        return roleRepository.findById(id).orElse(null);
    }


    @Override
    public RoleEntity findByRoleName(String roleName) {

        return roleRepository.findByRole(EnumRole.valueOf(roleName.toUpperCase()))
                .orElseThrow(() -> new IllegalArgumentException("Role not found: " + roleName));
    }


}
