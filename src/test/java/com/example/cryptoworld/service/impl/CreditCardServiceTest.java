package com.example.cryptoworld.service.impl;

import com.example.cryptoworld.models.entities.CreditCardEntity;
import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.enums.EnumCard;
import com.example.cryptoworld.models.enums.EnumRole;
import com.example.cryptoworld.models.service.AddCreditCardServiceModel;
import com.example.cryptoworld.models.service.ChangeRoleServiceModel;
import com.example.cryptoworld.models.view.UserByCardBalanceView;
import com.example.cryptoworld.repository.CreditCardRepository;
import com.example.cryptoworld.repository.RoleRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.repository.WalletRepository;
import com.example.cryptoworld.service.*;
import com.example.cryptoworld.service.Impl.CreditCardServiceImpl;
import com.example.cryptoworld.service.Impl.CryptoWorldUserService;
import com.example.cryptoworld.service.Impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreditCardServiceTest {

    private UserService userService;
    private AdminService adminService;
    private RoleService roleService;
    private ChangeRoleServiceModel changeRoleServiceModel;
    private PasswordEncoder passwordEncoder;
    private CryptoWorldUserService cryptoWorldUserService;
    private CountryService countryService;
    private AddCreditCardServiceModel addCreditCardServiceModel;
    private CreditCartService creditCartService;


    @Mock
    private CreditCardRepository creditCardRepository;
    @Mock
    private WalletRepository walletRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private UserRepository userRepository;



    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl(userRepository, new ModelMapper(), passwordEncoder, roleRepository, cryptoWorldUserService,
                roleService, countryService, walletRepository);

        creditCardRepository = Mockito.mock(CreditCardRepository.class);
        userRepository = Mockito.mock(UserRepository.class);

        creditCartService = new CreditCardServiceImpl(userRepository,new ModelMapper(),creditCardRepository,userService);


    }


    @Test
    public void testCreditCardAdd() {


        UserEntity userEntity = new UserEntity();

        userEntity.setUsername("Check");
        userEntity.setFullName("Ivan Ivanov");
        userEntity.setPassword("12345");

        // Role
        RoleEntity roleUser = new RoleEntity();
        roleUser.setId(2L);
        roleUser.setRole(EnumRole.USER);

        List<RoleEntity> roles = new ArrayList<>();
        roles.add(roleUser);
        userEntity.setRoles(roles);

        // END ROLES SET


        // Card

        CreditCardEntity cardEntity = new CreditCardEntity();

        cardEntity.setOwner(userEntity);
        cardEntity.setBalance(BigDecimal.valueOf(1000));

        // MOCK


        Mockito.lenient().when(userRepository.findByUsername("Check")).thenReturn(Optional.of(userEntity));

        Mockito.when(creditCardRepository.findByOwner("Ivan Ivanov")).thenReturn(cardEntity);


        CreditCardEntity expected = creditCartService.getByOwner("Ivan Ivanov");

        CreditCardEntity actual = cardEntity;

        Assertions.assertEquals(expected.getOwner().getFullName(),actual.getOwner().getFullName());

    }
}
