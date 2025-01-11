package com.xworkz.cmodule.service;

import com.xworkz.cmodule.dto.PersonsDTO;
import com.xworkz.cmodule.entity.PersonEntity;

public interface PersonService {

    public boolean save(PersonsDTO dto);

    public PersonEntity login(String email, String password);

    public long getCountofName(String name);

    public long getCountofEmail(String email);

    public long getCountofPhonenumber(String phoneNumber);

    public long getCountofAlternateEmail(String alternateemail);

    public long getCountofAlternatephonenumber(String alternatephone);

    public boolean resetPassword(String email, String oldPassword, String newPassword);

    public boolean saveEmail(String email);

    public boolean updateprofile(PersonsDTO personsDTO, String filePath);

    public boolean forgotpwd(String email);

    public boolean resetPasswordWithToken(String email, String token, String newPassword);

    public boolean resetemailforgotpwd(String email, String token);

}

