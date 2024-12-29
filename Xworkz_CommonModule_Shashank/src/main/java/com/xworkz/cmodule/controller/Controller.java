package com.xworkz.cmodule.controller;

import com.xworkz.cmodule.dto.PersonsDTO;
import com.xworkz.cmodule.entity.PersonEntity;
import com.xworkz.cmodule.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Component
@RequestMapping("/")
public class Controller {

    @Autowired
    PersonService personService;

    Controller() {
        System.out.println("Controller Constructor Created");
    }

    @PostMapping("/signupact")
    public String onsignup(Model model, @Valid PersonsDTO personsDTO, BindingResult bindingResult) {
        System.out.println("Sign Up DTO: " + personsDTO);

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getAllErrors());
            System.out.println("Controller " + bindingResult);
            return "signup";
        }
        boolean save = personService.save(personsDTO);
        if (save) {
            personService.saveEmail(personsDTO.getEmail());
            return "success";
        } else {
            return "signup";
        }
    }


    @PostMapping("/signinact")
    public String onlogin(String email, String password, Model model) {
        PersonEntity entity = personService.login(email, password);

        if (entity == null) {
            return "signin";
        }

        if (entity.getLoginCount() == -1) {
            return "resetpassword";
        }

        if (entity.getLoginCount() > 2) {
            return "signin";
        }

        if (entity.getLoginCount() == 0) {
            return "success";
        }

        return "signin";
    }

    @PostMapping("/resetPassword")
    public String onresetPassword(String email, String oldPassword, String newPassword, String confirmPassword) {
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

