package com.company.creditapplication.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "cap_CreditProgram")
@JmixEntity
@Entity(name = "cap_CreditProgram")
public class CreditProgram extends BaseEntity {
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @NotNull
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "BANK_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Bank bank;

    @Column(name = "CREDIT_TYPE", nullable = false)
    @NotNull
    private String creditType;

    @NotNull
    @Column(name = "MIN_INEREST_RATE", nullable = false)
    private Double minInterestRate;

    @Column(name = "MAX_INTEREST_RATE", nullable = false)
    @NotNull
    private Double maxInterestRate;

    public void setMinInterestRate(Double minInterestRate) {
        this.minInterestRate = minInterestRate;
    }

    public Double getMinInterestRate() {
        return minInterestRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMaxInterestRate() {
        return maxInterestRate;
    }

    public void setMaxInterestRate(Double maxInterestRate) {
        this.maxInterestRate = maxInterestRate;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CreditType getCreditType() {
        return creditType == null ? null : CreditType.fromId(creditType);
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType == null ? null : creditType.getId();
    }
}