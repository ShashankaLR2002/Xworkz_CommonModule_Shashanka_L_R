package com.xworkz.cmodule.service;

import com.xworkz.cmodule.dto.PersonsDTO;
import com.xworkz.cmodule.entity.PersonEntity;
import com.xworkz.cmodule.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Random;

@Service
public class PersonServiceImpl implements PersonService {
    String generatedPassword;
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

        generatedPassword = sb.toString();
        System.out.println("Generated password: " + generatedPassword);

        PersonEntity entity = new PersonEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setAlternateemail(dto.getAlternateemail());
        entity.setAlternatephone(dto.getAlternatephone());
        entity.setLocation(dto.getLocation());
        entity.setPassword(generatedPassword);
        entity.setLoginCount(-1);
        entity.setCreatedBy(dto.getName());
        entity.getCreatedDate();

        return personRepository.onsave(entity);
    }

    @Override
    public PersonEntity login(String email, String password) {
        PersonEntity entity = personRepository.onlogin(email, password);

        if (entity == null) {
            return null;
        }

        if (entity.getLoginCount() == -1) {
            return entity;
        }

        if (entity.getLoginCount() > 2) {
            System.out.println("Account locked for email: " + email);
            return null;
        }

        if (entity.getPassword().equals(password)) {
            entity.setLoginCount(0);
            personRepository.update(entity);
            return entity;
        } else {
            int updatedCount = entity.getLoginCount() + 1;
            entity.setLoginCount(updatedCount);
            personRepository.update(entity);
            return null;
        }
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
        long count = personRepository.getCountAlternateEmail(alternateemail);

        if (count > 0) {
            System.out.println("Alternate Email Aleady Exist " + alternateemail);
            return count;
        } else {
            return 0;
        }
    }

    @Override
    public long getCountofAlternatephonenumber(String alternatephone) {
        long count = personRepository.getCountofAlternatePhone(alternatephone);
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
                entity.setLoginCount(0);

                return personRepository.update(entity);
            }
        }
        return false;
    }

    @Override
    public boolean saveEmail(String email) {
        final String username = "lrshashank2002@gmail.com";
        final String userPassword = "xrlc rqiv zsus wcnx";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, userPassword);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Your Password");
            message.setText("Your generated password is: " + generatedPassword);

            Transport.send(message);

            System.out.println("Password sent " + generatedPassword);
            return true;

        } catch (MessagingException e) {
            System.err.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateprofile(PersonsDTO personsDTO) {
        PersonEntity entity = personRepository.findByName(personsDTO.getName());

        if (entity != null) {
            entity.setName(personsDTO.getName());
            entity.setEmail(personsDTO.getEmail());
            entity.setPhoneNumber(personsDTO.getPhoneNumber());
            entity.setAlternateemail(personsDTO.getAlternateemail());
            entity.setAlternatephone(personsDTO.getAlternatephone());
            entity.setLocation(personsDTO.getLocation());
            entity.setUpdatedBy(personsDTO.getName());
            entity.setUpdatedDate(LocalDateTime.now());
            return personRepository.update(entity);
        }

        return false;
    }


}











