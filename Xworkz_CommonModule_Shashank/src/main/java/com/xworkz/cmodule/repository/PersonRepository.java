package com.xworkz.cmodule.repository;

import com.xworkz.cmodule.entity.PersonEntity;

public interface PersonRepository {

   public boolean onsave(PersonEntity entity);
   public  PersonEntity onlogin(String email,String password);



}
