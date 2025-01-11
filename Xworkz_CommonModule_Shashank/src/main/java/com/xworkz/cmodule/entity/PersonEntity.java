package com.xworkz.cmodule.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.time.LocalDateTime;

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
@NamedQuery(name = "getPersonEntitylistbynameforupdateprofile", query = "SELECT p FROM PersonEntity p WHERE p.name = :name")

public class PersonEntity extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Digits(integer = 10, fraction = 0, message = "Number should contain 10 digits")
    @Column(name = "PhoneNumber")
    private long phoneNumber;

    @Column(name = "Alternateemail")
    private String alternateemail;

    @Digits(integer = 10, fraction = 0, message = "Number should contain 10 digits")
    @Column(name = "Alternatephonenumber")
    private long alternatephone;

    @Column(name = "Location")
    private String location;

    @Column(name = "Password")
    private String password;

    @Column(name = "LoginCount")
    private int loginCount;

    @Column(name = "ImageFilePath")
    private String filePath;

    @Column(name = "AccountLockTime")
    private LocalDateTime accountLockTime;

    @Column(name = "ResetToken")
    private String resetToken;


}
