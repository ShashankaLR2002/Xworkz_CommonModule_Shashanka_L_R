package com.xworkz.cmodule.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;

@Data

@Entity
@Table(name = "person_module_table")
@NamedQuery(name = "getPersonEntitylistByEmail", query = "SELECT p FROM PersonEntity p WHERE p.email = :email")
@NamedQuery(name = "getPersonEntitycountbyname", query = "SELECT COUNT(p) FROM PersonEntity p WHERE p.name = :name")
@NamedQuery(name = "getPersonEntitycountByEmail", query = "SELECT COUNT(p) FROM PersonEntity p WHERE p.email = :email")
@NamedQuery(name = "getPersonEntitycountbyphoneNumber", query = "SELECT COUNT(p) FROM PersonEntity p WHERE p.phoneNumber = :phoneNumber")
@NamedQuery(name = "getPersonEntitycountbyalternateemail", query = "SELECT COUNT(p) FROM PersonEntity p WHERE p.alternateemail = :alternateemail")
@NamedQuery(name = "getPersonEntitycountbyalternatephone", query = "SELECT COUNT(p) FROM PersonEntity p WHERE p.alternatephone = :alternatephone")
@NamedQuery(name = "getPersonEntitylistbyemailforResetpassword", query = "SELECT p FROM PersonEntity p WHERE p.email = :email")


public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "Name")
    String name;

    @Column(name = "Email")
    String email;
    @Digits(integer = 10, fraction = 0, message = "Number should contain 10 digits")

    @Column(name = "PhoneNumber")
    long phoneNumber;

    @Column(name = "Alternateemail")
    String alternateemail;
    @Digits(integer = 10, fraction = 0, message = "Number should contain 10 digits")

    @Column(name = "Alternatephonenumber")
    long alternatephone;

    @Column(name = "Location")
    String location;

    @Column(name = "Password")
    String password;

    @Column(name = "LoginCount")
    int LoginCount;


}