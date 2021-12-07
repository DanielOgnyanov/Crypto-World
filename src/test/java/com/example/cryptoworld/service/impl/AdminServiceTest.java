package com.example.cryptoworld.service.impl;


import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.enums.EnumAddOrRemove;
import com.example.cryptoworld.models.enums.EnumRole;
import com.example.cryptoworld.models.service.ChangeRoleServiceModel;
import com.example.cryptoworld.repository.RoleRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.repository.WalletRepository;
import com.example.cryptoworld.service.AdminService;
import com.example.cryptoworld.service.CountryService;
import com.example.cryptoworld.service.Impl.AdminServiceImpl;
import com.example.cryptoworld.service.Impl.CryptoWorldUserService;
import com.example.cryptoworld.service.Impl.RoleServiceImpl;
import com.example.cryptoworld.service.Impl.UserServiceImpl;
import com.example.cryptoworld.service.RoleService;
import com.example.cryptoworld.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    private AdminService adminService;
    private UserService userService;
    private RoleService roleService;
    private ChangeRoleServiceModel changeRoleServiceModel;
    private PasswordEncoder passwordEncoder;
    private CryptoWorldUserService cryptoWorldUserService;
    private CountryService countryService;


    @Mock
    private RoleRepository roleRepository;
    @Mock
    private WalletRepository walletRepository;
    @Mock
    private UserRepository userRepository;


    @BeforeEach
    public void setUp() {

        roleService = new RoleServiceImpl(roleRepository);


        userService = new UserServiceImpl(userRepository, new ModelMapper(), passwordEncoder, roleRepository, cryptoWorldUserService,
                roleService, countryService, walletRepository);


        adminService = new AdminServiceImpl(userService, userRepository, roleService);


    }


    @Test
    void testExistingUser() {

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername("Check");
        userEntity.setPassword("12345");

        // Role
        RoleEntity roleUser = new RoleEntity();
        roleUser.setId(2L);
        roleUser.setRole(EnumRole.USER);

        RoleEntity roleAdmin = new RoleEntity();
        roleAdmin.setId(1L);
        roleAdmin.setRole(EnumRole.ADMIN);

        List<RoleEntity> roles = new ArrayList<>();
        roles.add(roleUser);
        userEntity.setRoles(roles);

        // END ROLES SET

        // MOCK

        Mockito.when(roleRepository.findById(1L)).thenReturn(Optional.of(roleAdmin));

        Mockito.lenient().when(userRepository.findByUsername("Check")).thenReturn(Optional.of(userEntity));

        // END MOCK


        // INIT ROLE SERVICE MODEL ADD
        changeRoleServiceModel = new ChangeRoleServiceModel();

        changeRoleServiceModel.setAddOrRemove(EnumAddOrRemove.ADD);
        changeRoleServiceModel.setUsername("Check");

        adminService.changeRole(changeRoleServiceModel);


        Assertions.assertEquals(userEntity.getRoles().get(1).getRole().name(), roleAdmin.getRole().name());

        // END


        // INIT ROLE SERVICE MODEL REMOVE
        changeRoleServiceModel = new ChangeRoleServiceModel();

        changeRoleServiceModel.setAddOrRemove(EnumAddOrRemove.REMOVE);
        changeRoleServiceModel.setUsername("Check");


        adminService.changeRole(changeRoleServiceModel);

        int expectedListRoleSize = 1;

        int actual = userEntity.getRoles().size();

        Assertions.assertEquals(expectedListRoleSize, actual);

        // END
    }

}
