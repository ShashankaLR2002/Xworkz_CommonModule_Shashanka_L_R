package com.xworkz.courseregistration.service;

import com.xworkz.courseregistration.dto.XworkzDTO;
import com.xworkz.courseregistration.entity.XworkzEntity;
import com.xworkz.courseregistration.repository.XworkzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class XworkzServiceImpl implements XwrokzService {

    @Autowired
    private XworkzRepository xworkzRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public boolean validate(XworkzDTO dto) {
        boolean valid = true;

        if (dto.getName() != null && dto.getName().length() > 4) {

            System.out.println("name is valid");
        } else {
            System.out.println("Name is invalid");
            valid = false;
        }

        if (dto.getAge() > 18) {
            System.out.println("age is valid");
        } else {
            System.out.println("age should be greater than 18");
            valid = false;
        }
        if (dto.getEmail() != null && dto.getEmail().contains("@gmail.com")) {
            System.out.println("email is valid");
        } else {
            System.out.println("Email Should be valid");
            valid = false;
        }
        if (dto.getPassword().equals(dto.getConfirmPassword())) {
            System.out.println("confirm password  is valid");

        } else {
            System.out.println("confirm password  is not valid");
            valid = false;

        }

        if (dto.getPhonenumber() != null && dto.getPhonenumber().length() == 10) {
            System.out.println("Phone Number is valid");
        } else {
            System.out.println("Phone Number is not valid");
            valid = false;

        }
        if (valid) {
            String encryptedPassword = passwordEncoder.encode(dto.getPassword());

            XworkzEntity entity = new XworkzEntity();
            entity.setName(dto.getName());
            entity.setAge(dto.getAge());
            entity.setEmail(dto.getEmail());
            entity.setPassword(encryptedPassword);
            entity.setPhonenumber(dto.getPhonenumber());
            xworkzRepository.onSave(entity);
        }
        System.out.println(valid);
        return valid;


    }

    @Override
    public XworkzEntity getUserByEmailAndPassword(String email, String password) {
        XworkzEntity entity = xworkzRepository.findByemail(email);
        if (entity != null && passwordEncoder.matches(password, entity.getPassword())) {
            return entity;

        } else {
            return null;

        }
    }
}




