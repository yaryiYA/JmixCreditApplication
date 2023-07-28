package com.company.creditapplication.dto;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

@JmixEntity(name = "cap_PassportDto")
public class PassportDto {

    private UUID id;

    private Integer version;


    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @InstanceName
    private String firstName;

    private String lastName;

    private String surname;

    private Integer serialPassport;

    private Integer numberPassport;

    public void setNumberPassport(Integer numberPassport) {
        this.numberPassport = numberPassport;
    }

    public Integer getNumberPassport() {
        return numberPassport;
    }

    public UUID getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public Date getCreatedDate() {
        return createdDate;
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
    public void setId(UUID id) {
        this.id = id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}