package com.xworkz.cmodule.dto;

import com.xworkz.cmodule.entity.AbstractAuditEntity;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PersonsDTO extends AbstractAuditEntity {
    @NotNull
    @Size(min = 2, max = 20, message = "Name must be between 2 and 10 characters")
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Digits(integer = 10, fraction = 0, message = "Number should contain 10 digits")
    private long phoneNumber;

    @NotNull
    @Email(message = "Alternate email should be valid")
    private String alternateemail;

    @NotNull
    @Digits(integer = 10, fraction = 0, message = "Number should contain 10 digits")
    private long alternatephone;

    @NotNull
    @Size(min = 2, max = 20, message = "Location must be between 2 and 10 characters")
    private String location;


}
