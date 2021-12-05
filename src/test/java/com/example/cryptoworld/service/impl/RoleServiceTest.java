package com.example.cryptoworld.service.impl;


import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.enums.EnumRole;
import com.example.cryptoworld.repository.RoleRepository;
import com.example.cryptoworld.service.Impl.RoleServiceImpl;
import com.example.cryptoworld.service.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.management.relation.Role;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {


    private RoleEntity roleEntity;
    private RoleServiceImpl roleService;

    @Mock
    private RoleRepository roleRepository;


    @BeforeEach
    public void init() {

        this.roleEntity = new RoleEntity();

        this.roleEntity.setRole(EnumRole.ADMIN);

        this.roleRepository = Mockito.mock(RoleRepository.class);

    }


    @Test
    public void testInitRoleInDb() {

        Mockito.when(roleRepository.findAll()).thenReturn(List.of(this.roleEntity));

        RoleService roleService = new RoleServiceImpl(this.roleRepository);

        roleService.InitRoleInDb();

        Assertions.assertEquals(1, this.roleRepository.findAll().size());


    }
}
