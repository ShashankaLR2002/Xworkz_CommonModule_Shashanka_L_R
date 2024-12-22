package com.xworkz.cmodule.controller;

import com.xworkz.cmodule.dto.PersonsDTO;
import com.xworkz.cmodule.entity.PersonEntity;
import com.xworkz.cmodule.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class Controller {

    @Autowired
    PersonService personService;

    Controller() {
        System.out.println("Controller Constructor Created");
    }

    @PostMapping("/signupact")
    public String onsignup(PersonsDTO dto) {
        System.out.println("Sign Up DTO: " + dto);
        boolean save = personService.save(dto);
        if (save) {
            return "success";
        } else {
            return "signup";
        }
    }

    @PostMapping("/signinact")
    public String onlogin(String email, String password, Model model) {
        System.out.println("Sign In with email: " + email);
        PersonEntity entity = personService.login(email, password);
        if (entity != null) {
            return "success";
        } else {
            return "signin";
        }
    }

    @PostMapping("/resetPassword")
    public String resetPassword(String email, String oldPassword, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            return "resetpassword";
        }

        boolean isValid = personService.resetPassword(email, oldPassword, newPassword);
        if (isValid) {
            return "signin";
        } else {
            return "resetpassword";
        }
    }


}

