package com.xworkz.cmodule.controller;

import com.xworkz.cmodule.constants.LocationConstants;
import com.xworkz.cmodule.dto.PersonsDTO;
import com.xworkz.cmodule.entity.PersonEntity;
import com.xworkz.cmodule.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequestMapping("/")
public class Controller {

    @Autowired
    PersonService personService;
    private List<LocationConstants> locref = new ArrayList<>(Arrays.asList(LocationConstants.values()));

    Controller() {
        System.out.println("Controller Constructor Created");
    }

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
            return "registrationsuccess";
        } else {
            return "signup";
        }
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
            System.out.println("Logged in as :" + entity.getName());
            return "success";
        }

        if (entity.getLoginCount() > 2) {
            return "signin";
        }

        if (entity.getLoginCount() == 0) {
            httpSession.setAttribute("loggedInUser", entity);
            System.out.println("Logged in as :" + entity.getName());
            return "success";
        }
        return "signin";
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
            return "signin";
        } else {
            return "resetpassword";
        }
    }

    @GetMapping("/Updateprofileact")
    public String updateprofile(Model model) {
        model.addAttribute("listoflocation", locref);
        return "updateprofile";
    }

    @PostMapping("/updateUserProfile")
    public String updateprofile(@Valid PersonsDTO personsDTO, BindingResult bindingResult, @RequestParam("Img") MultipartFile multipartFile) throws IOException {
        if (bindingResult.hasErrors()) {
            return "updateprofile";
        }

        String filePath = null;
        if (!multipartFile.isEmpty()) {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get("D:\\Commons-File-Upload\\" + System.currentTimeMillis() + ".jpg");
            Files.write(path, bytes);
            filePath = path.toString();
        }

        boolean isUpdated = personService.updateprofile(personsDTO, filePath);

        if (isUpdated) {
            return "success";
        } else {
            return "updateprofile";
        }
    }


    @GetMapping("/forgotPassword")
    public String forgotpwd() {

        return "forgotpassword";
    }


    @PostMapping("/forgotPwd")

    public String forgotpassword(String email, String newPassword,String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            return "resetpassword";
        }
        Boolean isupdated = personService.forgotpwd(email, newPassword);
        if (isupdated) {
            return "signin";
        }

        return "forgotpassword";
    }


//    @PostMapping("/updateimage")
//    public String updateimage(@RequestParam("Img") MultipartFile multipartFile, HttpSession httpSession) throws IOException {
//        if (multipartFile.isEmpty()) {
//            return "success";
//        } else {
//            System.out.println("MultipartFile: " + multipartFile);
//            System.out.println("FileName: " + multipartFile.getOriginalFilename());
//            System.out.println("ContentType: " + multipartFile.getContentType());
//
//            PersonEntity loggedInUser = (PersonEntity) httpSession.getAttribute("loggedInUser");
//
//            if (loggedInUser == null) {
//                return "signin";
//            }
//
//            byte[] bytes = multipartFile.getBytes();
//            Path path = Paths.get("D:\\Commons-File-Upload\\" + System.currentTimeMillis() + ".jpg");
//            Files.write(path, bytes);
//
//            String filePath = path.getFileName().toString();
//            System.out.println("FilePath: " + filePath);
//
//
//            return "imguploadsuccess";
//        }
//    }
}

