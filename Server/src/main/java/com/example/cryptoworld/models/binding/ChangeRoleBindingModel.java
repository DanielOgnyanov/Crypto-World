package com.example.cryptoworld.models.binding;

import com.example.cryptoworld.models.enums.EnumAddOrRemove;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChangeRoleBindingModel {


    private String username;
    private EnumAddOrRemove addOrRemove;

    public ChangeRoleBindingModel() {
    }

    @NotNull(message = "Username cannot be empty !")
    @NotEmpty(message = "Username cannot be empty !")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters !")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull(message = "Select add or remove !")
    public EnumAddOrRemove getAddOrRemove() {
        return addOrRemove;
    }

    public void setAddOrRemove(EnumAddOrRemove addOrRemove) {
        this.addOrRemove = addOrRemove;
    }

}
