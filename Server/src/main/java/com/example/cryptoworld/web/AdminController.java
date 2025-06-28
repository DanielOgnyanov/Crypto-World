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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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



    // OLD CODE

     @GetMapping("/setting")

    public String adminPanel(Model model) {

        if (!model.containsAttribute("changeRoleBindingModel")) {
            model.addAttribute("changeRoleBindingModel", new ChangeRoleBindingModel());
        }

        if (!model.containsAttribute("changeRoleBindingModel")) {
            model.addAttribute("changeRoleBindingModel", new ChangeRoleBindingModel());
            model.addAttribute("userCheckIfIsPresent", false);
        }

        if (!model.containsAttribute("changeRoleBindingModel")) {
            model.addAttribute("changeRoleBindingModel", new ChangeRoleBindingModel());
            model.addAttribute("findIfUserHaveThisRole", false);
        }

        if (!model.containsAttribute("changeRoleBindingModel")) {
            model.addAttribute("changeRoleBindingModel", new ChangeRoleBindingModel());
            model.addAttribute("removeRoleCheck", false);
        }


        // view add

        model.addAttribute("logDeposit", logDepositService.getAllDepositOrderedDesc());

        model.addAttribute("logSell", logSellService.getAllSellOrderDesc());

        model.addAttribute("user", userService.getAllUsersOrderedByUsername());

        model.addAttribute("userByCardBalance", creditCartService.getAllUserOrderedByBalance());

        return "admin";
    }


    @PostMapping("/setting")
    public String createAccount(@Valid ChangeRoleBindingModel changeRoleBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("changeRoleBindingModel", changeRoleBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.changeRoleBindingModel", bindingResult);

            return "redirect:setting";
        }

        if ((!userService.existByUsername(changeRoleBindingModel.getUsername()))) {
            redirectAttributes.addFlashAttribute("changeRoleBindingModel", changeRoleBindingModel);
            redirectAttributes.addFlashAttribute("userCheckIfIsPresent", true);

            return "redirect:setting";
        }


        if (userService.checkIfUserHasRoleOrNot(changeRoleBindingModel) &&
                !changeRoleBindingModel.getAddOrRemove().name().equals("REMOVE")) {

            redirectAttributes.addFlashAttribute("changeRoleBindingModel", changeRoleBindingModel);
            redirectAttributes.addFlashAttribute("findIfUserHaveThisRole", true);

            return "redirect:setting";
        }

        if (!userService.checkIfUserHasRoleOrNot(changeRoleBindingModel) &&
                changeRoleBindingModel.getAddOrRemove().name().equals("REMOVE")) {

            redirectAttributes.addFlashAttribute("changeRoleBindingModel", changeRoleBindingModel);
            redirectAttributes.addFlashAttribute("removeRoleCheck", true);

            return "redirect:setting";
        }


        adminService.changeRole
                (modelMapper.map(changeRoleBindingModel, ChangeRoleServiceModel.class));


        return "redirect:setting";
    }
}
