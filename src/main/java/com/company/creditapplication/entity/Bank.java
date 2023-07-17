package com.company.creditapplication.entity;

import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "cap_Bank")
@JmixEntity
@Entity(name = "cap_Bank")
public class Bank extends BaseEntity {
    @NotEmpty(message = "{msg://com.company.creditapplication.entity/Bank.name.validation.NotEmpty}")
    @Length(min = 3, max = 20)
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Composition
    @OneToMany(mappedBy = "bank")
    private List<CreditProgram> creditProgram;

    @Composition
    @OneToMany(mappedBy = "bank")
    private List<Offer> offer;

    public List<Offer> getOffer() {
        return offer;
    }

    public void setOffer(List<Offer> offer) {
        this.offer = offer;
    }

    public List<CreditProgram> getCreditProgram() {
        return creditProgram;
    }

    public void setCreditProgram(List<CreditProgram> creditProgram) {
        this.creditProgram = creditProgram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}