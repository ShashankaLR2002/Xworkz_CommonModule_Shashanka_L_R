package com.xworkz.cmodule.controller;

import com.xworkz.cmodule.constants.LocationConstants;
import com.xworkz.cmodule.dto.PersonsDTO;
import com.xworkz.cmodule.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequestMapping("/")
public class SignupController {
    SignupController() {
        System.out.println("SignupController Constructor Created");
    }

    @Autowired
    PersonService personService;
    private List<LocationConstants> locref = new ArrayList<>(Arrays.asList(LocationConstants.values()));

    @GetMapping("/SignupAct")
    public String signup(Model model) {
        model.addAttribute("listoflocation", locref);
        return "signup";
    }

    @PostMapping("/signupact")
    public String onsignup(Model model, @Valid PersonsDTO personsDTO, BindingResult bindingResult) {
        System.out.println("Sign Up DTO: " + personsDTO);
        System.out.println("Executing the save method " + personsDTO.getLocation());

        locref.forEach(n -> System.out.println("Locations" + n));
        model.addAttribute("listoflocation", locref);

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getAllErrors());
            System.out.println("Controller " + bindingResult);
            return "signup";
        }

        boolean save = personService.save(personsDTO);
        if (save) {
            personService.saveEmail(personsDTO.getEmail());
            return "signin";
        } else {
            return "signup";
        }
    }
}
