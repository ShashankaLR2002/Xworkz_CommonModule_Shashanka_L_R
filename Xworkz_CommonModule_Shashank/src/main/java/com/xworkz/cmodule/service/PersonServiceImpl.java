package com.xworkz.cmodule.service;

import com.xworkz.cmodule.dto.PersonsDTO;
import com.xworkz.cmodule.entity.PersonEntity;
import com.xworkz.cmodule.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean save(PersonsDTO dto) {
        StringBuilder sb = new StringBuilder();
        int length = 6;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        String generatedPassword = sb.toString();
        System.out.println("Generated password: " + generatedPassword);

        PersonEntity entity = new PersonEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setAlternateemail(dto.getAlternateemail());
        entity.setAlternatephone(dto.getAlternatephone());
        entity.setLocation(dto.getLocation());
        entity.setPassword(generatedPassword);

        return personRepository.onsave(entity);
    }

    @Override
    public PersonEntity login(String email, String password) {
        PersonEntity entity = personRepository.onlogin(email, password);

        if (entity != null) {
            if (entity.getPassword().equals(password)) {
                System.out.println("Login successful for email: " + email);
                return entity;
            } else {
                System.out.println("Invalid password for email: " + email);

            }
            return null;
        } else {
            System.out.println("No user  with email: " + email);
        }
        return personRepository.onlogin(email, password);
    }
}
