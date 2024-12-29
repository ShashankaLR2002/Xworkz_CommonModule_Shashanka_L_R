package com.xworkz.cmodule.repository;

import com.xworkz.cmodule.entity.PersonEntity;

public interface PersonRepository {

    public boolean onsave(PersonEntity entity);

    public PersonEntity onlogin(String email, String password);

    public long getCountofName(String name);

    public long getCountofEmail(String email);

    public long getCountofNumber(String phoneNumber);

    public long getCountAlternateEmail(String alternateemail);

    public long getCountofAlternatePhone(String alternatephone);

    boolean update(PersonEntity entity);

    PersonEntity findByEmail(String email);


}
