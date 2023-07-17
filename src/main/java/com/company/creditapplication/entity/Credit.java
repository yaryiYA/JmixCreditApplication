package com.company.creditapplication.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Table(name = "cap_Credit")
@JmixEntity
@Entity(name = "cap_Credit")
public class Credit extends BaseEntity {

    @Column(name = "IS_ACTIVE", nullable = false)
    @NotNull
    private Boolean isActive = false;

    @Column(name = "AMOUNT", precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(name = "PERCENT_")
    private Double percent;

    @Column(name = "NUMBER_MOUNTH")
    private Integer numberMounth;

    public Integer getNumberMounth() {
        return numberMounth;
    }

    public void setNumberMounth(Integer numberMounth) {
        this.numberMounth = numberMounth;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}