package com.company.creditapplication.entity;

import com.company.creditapplication.dto.PassportDto;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Table(name = "cap_Client")
@JmixEntity
@Entity(name = "cap_Client")
public class Client extends BaseEntity {
    @NotBlank(message = "{msg://com.company.creditapplication.entity/Client.firstName.validation.NotBlank}")
    @InstanceName
    @Column(name = "FIRST_NAME", nullable = false)
    @NotNull
    private String firstName;

    @NotBlank(message = "{msg://com.company.creditapplication.entity/Client.lastName.validation.NotBlank}")
    @Column(name = "LAST_NAME", nullable = false)
    @NotNull

    private String lastName;

    @NotBlank(message = "{msg://com.company.creditapplication.entity/Client.surname.validation.NotBlank}")
    @Column(name = "SURNAME")
    private String surname;

    @Pattern(message = "{msg://com.company.creditapplication.entity/Client.numberPhone.validation.Pattern}", regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    @NotBlank(message = "{msg://com.company.creditapplication.entity/Client.numberPhone.validation.NotBlank}")
    @Column(name = "NUMBER_PHONE", nullable = false)
    @NotNull
    private String numberPhone;

    @NotBlank(message = "{msg://com.company.creditapplication.entity/Client.email.validation.NotBlank}")
    @Column(name = "EMAIL", nullable = false)
    @NotNull
    private String email;

    @Column(name = "PASSPORT_ID")
    private UUID passportID;

    @JmixProperty
    @Transient
    private PassportDto passportDto;

    public PassportDto getPassportDto() {
        return passportDto;
    }

    public void setPassportDto(PassportDto passportDto) {
        this.passportDto = passportDto;
    }

    public UUID getPassportID() {
        return passportID;
    }

    public void setPassportID(UUID passportID) {
        this.passportID = passportID;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}