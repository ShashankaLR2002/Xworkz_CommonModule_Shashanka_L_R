package com.xworkz.cmodule.restcontroller;

import com.xworkz.cmodule.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onName(@PathVariable String name, Model model) {
        long count = personService.getCountofName(name);

        if (count > 0) {
            model.addAttribute("disp", "Name already Exist");
            return "Name already exist";
        } else {
            System.out.println("Name does not exist: " + name);
            return "  ";
        }
    }


    @GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onEmail(@PathVariable String email) {
        long count = personService.getCountofEmail(email);
        if (count > 0) {
            return "Email already exist";
        } else {
            System.out.println("email does not exist: " + email);
            return "  ";
        }
    }

    @GetMapping(value = "/phoneNumber/{phoneNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onPhoneNumber(@PathVariable String phoneNumber) {

        long count = personService.getCountofPhonenumber(phoneNumber);

        if (count > 0) {
            return "PhoneNumber already exist";

        } else {
            return " ";

        }

    }


    @GetMapping(value = "/alternateemail/{alternateemail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAlternateemail(@PathVariable String alternateemail) {

        long count = personService.getCountofAlternateEmail(alternateemail);
        if (count > 0) {
            return "Alternateemail already exist";
        } else {
            return "  ";
        }
    }

    @GetMapping(value = "/alternatephone/{alternatephone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAlternatePhonenumber(@PathVariable String alternatephone) {

        long count = personService.getCountofAlternatephonenumber(alternatephone);
        if (count > 0) {
            return "Alternatephone already exist";
        } else {
            return " ";
        }
    }


}



