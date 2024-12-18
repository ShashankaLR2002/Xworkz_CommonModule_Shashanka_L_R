package com.xworkz.cmodule.service;

import com.xworkz.cmodule.dto.PersonsDTO;
import com.xworkz.cmodule.entity.PersonEntity;

public interface PersonService {

    public boolean  save(PersonsDTO dto);
    public PersonEntity login(String email, String password);



}
