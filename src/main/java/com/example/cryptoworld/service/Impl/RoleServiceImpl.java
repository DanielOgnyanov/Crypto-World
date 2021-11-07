package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.repository.RoleRepository;
import com.example.cryptoworld.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void InitRoleInDb() {

    }
}
