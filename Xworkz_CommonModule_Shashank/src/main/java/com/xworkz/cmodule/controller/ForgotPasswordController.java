package com.xworkz.cmodule.controller;

import com.xworkz.cmodule.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@RequestMapping("/")
public class ForgotPasswordController {

    @Autowired
    PersonService personService;

    ForgotPasswordController() {
        System.out.println("ForgotPasswordController Constructor Created");
    }


    @GetMapping("/forgotPwd")
    public String forgotPwd(String email, Model model) {
        boolean result = personService.forgotpwd(email);
        if (result) {
            model.addAttribute("email", email);
            return "setpassword";
        }

        return "forgotpassword";
    }


    @PostMapping("/resetPwd")
    public String resetPwd(String email, String token, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            return "setpassword";
        }
        boolean result = personService.resetPasswordWithToken(email, token, newPassword);
        if (result) {
            return "resetsuccess";
        }
        return "setpassword";
    }
}
