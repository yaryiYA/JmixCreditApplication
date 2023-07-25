package com.company.creditapplication.dto;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

@JmixEntity(name = "cap_PassportDto")
public class PassportDto extends BaseDto {
    @InstanceName
    private String firstName;

    private String lastName;

    private String surname;

    private Integer serialPassport;

    private String numberPassport;

    public String getNumberPassport() {
        return numberPassport;
    }

    public void setNumberPassport(String numberPassport) {
        this.numberPassport = numberPassport;
    }

    public Integer getSerialPassport() {
        return serialPassport;
    }

    public void setSerialPassport(Integer serialPassport) {
        this.serialPassport = serialPassport;
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