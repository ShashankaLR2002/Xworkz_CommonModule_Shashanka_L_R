package com.xworkz.cmodule.controller;

import com.xworkz.cmodule.constants.ImagePath;
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
public class UpdateProfileController {
    @Autowired
    PersonService personService;
    private List<LocationConstants> locref = new ArrayList<>(Arrays.asList(LocationConstants.values()));

    UpdateProfileController() {
        System.out.println("UpdateProfileController Constructor Created");
    }

    @GetMapping("/Updateprofileact")
    public String updateprofile(Model model) {
        model.addAttribute("listoflocation", locref);
        return "updateprofile";
    }

    @PostMapping("/updateUserProfile")
    public String updateprofile(Model model, @Valid PersonsDTO personsDTO, BindingResult bindingResult,
                                @RequestParam("Img") MultipartFile multipartFile, HttpSession httpSession) throws IOException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listoflocation", locref);
            return "updateprofile";
        }

        String filePath = null;

        if (!multipartFile.isEmpty()) {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(ImagePath.IMAGE_PATH.getPath() + System.currentTimeMillis() + ".jpg");
            Files.write(path, bytes);
            filePath = path.getFileName().toString();
        }

        boolean isUpdated = personService.updateprofile(personsDTO, filePath);

        if (isUpdated) {
            httpSession.setAttribute("imageName", filePath);
            return "updateprofilesuccess";

        } else {
            model.addAttribute("listoflocation", locref);
            return "updateprofile";
        }

    }


}
