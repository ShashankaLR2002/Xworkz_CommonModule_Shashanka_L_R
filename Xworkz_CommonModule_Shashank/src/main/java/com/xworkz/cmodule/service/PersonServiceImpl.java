package com.xworkz.cmodule.service;

import com.xworkz.cmodule.dto.PersonsDTO;
import com.xworkz.cmodule.entity.PersonEntity;
import com.xworkz.cmodule.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
        entity.setResetstatus(-1);
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
            System.out.println("No user with email: " + email);
        }
        return personRepository.onlogin(email, password);
    }

    @Override
    public long getCountofName(String name) {
        long count = personRepository.getCountofName(name);

        if (count > 0) {
            System.out.println("Name exists: " + name);

        } else {
            return 0;
        }


        return count;
    }

    @Override
    public long getCountofEmail(String email) {
        long count = personRepository.getCountofEmail(email);

        if (count > 0) {

            System.out.println("Email exist" + email);
            return count;

        } else {

            return 0;
        }
    }

    @Override
    public long getCountofPhonenumber(String phoneNumber) {
        long count = personRepository.getCountofNumber(phoneNumber);

        if (count > 0) {
            System.out.println("Phone number exist" + phoneNumber);
            return count;
        } else {
            return 0;
        }
    }

    @Override
    public long getCountofAlternateEmail(String alternateemail) {
        long count = personRepository.getAlternateEmail(alternateemail);

        if (count > 0) {
            System.out.println("Alternate Email Aleady Exist " + alternateemail);
            return count;
        } else {
            return 0;
        }
    }

    @Override
    public long getCountofAlternatephonenumber(String alternatephone) {
        long count = personRepository.getAlternatePhone(alternatephone);
        if (count > 0) {
            System.out.println("Alternatehone aleady Exist " + alternatephone);
            return count;
        } else

            return 0;
    }

    @Override
    public boolean resetPassword(String email, String oldPassword, String newPassword) {
        PersonEntity entity = personRepository.findByEmail(email);
        if (entity != null) {
            if (entity.getPassword().equals(oldPassword)) {
                String encryptedPassword = passwordEncoder.encode(newPassword);

                entity.setPassword(encryptedPassword);
                entity.setResetstatus(0);

                return personRepository.update(entity);
            }
        }
        return false;
    }


}




