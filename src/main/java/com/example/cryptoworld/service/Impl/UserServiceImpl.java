package com.example.cryptoworld.service.Impl;

import com.example.cryptoworld.models.entities.RoleEntity;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.enums.EnumCountry;
import com.example.cryptoworld.models.enums.EnumRole;
import com.example.cryptoworld.models.service.UserRegistrationServiceModel;
import com.example.cryptoworld.repository.RoleRepository;
import com.example.cryptoworld.repository.UserRepository;
import com.example.cryptoworld.service.CountryService;
import com.example.cryptoworld.service.RoleService;
import com.example.cryptoworld.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final CryptoWorldUserService cryptoWorldUserService;
    private final RoleService roleService;
    private final CountryService countryService;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository,
                           CryptoWorldUserService cryptoWorldUserService, RoleService roleService,
                           CountryService countryService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.cryptoWorldUserService = cryptoWorldUserService;

        this.roleService = roleService;
        this.countryService = countryService;
    }


    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void register(UserRegistrationServiceModel userRegistrationServiceModel) {

        RoleEntity userRole = roleRepository.findByRole(EnumRole.USER).orElse(null);

        UserEntity userEntity = modelMapper.map(userRegistrationServiceModel, UserEntity.class);

        userEntity.setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()));


        userEntity.addRole(userRole);


        userEntity.setCountry(userRegistrationServiceModel.getCountry());

        userEntity.setWalletAddress(generateWalletAddress());

        userRepository.save(userEntity);


    }


    private String generateWalletAddress() {

        String allChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        int lenAddress = 10;
        StringBuilder sb = new StringBuilder(lenAddress);

        for (int i = 0; i < lenAddress; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }

        return sb.toString();
    }


    public void initializeUsers() {
        if (userRepository.count() == 0) {

            RoleEntity adminRole = roleRepository.findByRole(EnumRole.ADMIN).orElse(null);
            RoleEntity userRole = roleRepository.findByRole(EnumRole.USER).orElse(null);

            UserEntity admin = new UserEntity();


            admin.setUsername("admin");
            admin.setFullName("Admin Adminov");
            admin.setPassword(passwordEncoder.encode("test_2021"));
            admin.setEmail("admin@test.bg");
            admin.setCountry(EnumCountry.Bulgaria);
            admin.setRoles(List.of(adminRole, userRole));
            admin.setWalletAddress("test");
            admin.setDepositSet(null);

            userRepository.save(admin);

            UserEntity user = new UserEntity();

            user.setUsername("ivan");
            user.setFullName("Ivan Cekov");
            user.setPassword(passwordEncoder.encode("12345"));
            user.setEmail("ivan@a.bg");
            user.setCountry(EnumCountry.Bulgaria);
            user.setRoles(List.of(userRole));
            user.setWalletAddress(generateWalletAddress());
            user.setDepositSet(new HashSet<>());

            userRepository.save(user);
        }
    }
}
