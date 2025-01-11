package com.xworkz.cmodule.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.xworkz.cmodule.constants.LocationConstants;
import com.xworkz.cmodule.entity.PersonEntity;
import com.xworkz.cmodule.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequestMapping("/")
public class SigninController {

    @Autowired
    PersonService personService;
    private List<LocationConstants> locref = new ArrayList<>(Arrays.asList(LocationConstants.values()));

    SigninController() {
        System.out.println("SigninController Constructor Created");
    }


    @GetMapping("/SigninAct")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signinact")
    public String onlogin(String email, String password, HttpSession httpSession) {
        PersonEntity entity = personService.login(email, password);

        if (entity == null) {
            return "signin";
        }

        if (entity.getLoginCount() == -1) {
            httpSession.setAttribute("loggedInUser", entity);

            return "resetpassword";
        }

        if (entity.getLoginCount() > 2) {
            return "signin";
        }

        if (entity.getLoginCount() == 0) {
            httpSession.setAttribute("loggedInUser", entity);

            String filePath = entity.getFilePath() != null ? entity.getFilePath() : "default.jpg";
            httpSession.setAttribute("imageName", filePath);

            return "registrationsuccess";
        }

        return "signin";
    }

}
