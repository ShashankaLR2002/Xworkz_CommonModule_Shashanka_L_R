package com.xworkz.cmodule.controller;

import com.xworkz.cmodule.constants.LocationConstants;

import com.xworkz.cmodule.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequestMapping("/")
public class ResetpasswordController {
    @Autowired
    PersonService personService;
    private List<LocationConstants> locref = new ArrayList<>(Arrays.asList(LocationConstants.values()));

    ResetpasswordController() {
        System.out.println("ResetpasswordController Constructor Created");
    }


    @GetMapping("/ResetAct")
    public String resetpassword() {
        return "resetpassword";
    }

    @PostMapping("/resetPassword")
    public String onresetPassword(String email, String oldPassword, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            return "resetpassword";
        }
        boolean isValid = personService.resetPassword(email, oldPassword, newPassword);
        if (isValid) {
            return "resetsuccess";
        } else {
            return "resetpassword";
        }
    }


}
