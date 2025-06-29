package com.example.cryptoworld.web;

import com.example.cryptoworld.models.dto.ChangeRoleBindingModel;
import com.example.cryptoworld.models.entities.UserEntity;
import com.example.cryptoworld.models.service.ChangeRoleServiceModel;
import com.example.cryptoworld.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final AdminService adminService;
    private final RoleService roleService;
    private final LogDepositService logDepositService;
    private final LogSellService logSellService;
    private final CreditCartService creditCartService;

    public AdminController(ModelMapper modelMapper, UserService userService, AdminService adminService, RoleService roleService, LogDepositService logDepositService, LogSellService logSellService, CreditCartService creditCartService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.adminService = adminService;
        this.roleService = roleService;
        this.logDepositService = logDepositService;
        this.logSellService = logSellService;
        this.creditCartService = creditCartService;
    }

    @GetMapping("/logged")

    public ResponseEntity<Integer> getAllLoggedUser() {

        int loggedUserCount = adminService.getAllLoggedUser().size();

        return new ResponseEntity<>(loggedUserCount, HttpStatus.OK);

    }



    @PostMapping("/role")
    public ResponseEntity<String> changeUserRole(@RequestBody ChangeRoleServiceModel changeRoleServiceModel) {
        try {
            adminService.changeRole(changeRoleServiceModel);
            return ResponseEntity.ok("User role updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update user role: " + e.getMessage());
        }
    }
}
