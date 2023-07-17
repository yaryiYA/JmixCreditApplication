package com.company.creditapplication.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "cap_Offer")
@JmixEntity
@Entity(name = "cap_Offer")
public class Offer extends BaseEntity {
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Client client;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "BANK_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Bank bank;

    @JoinColumn(name = "CREDIT_PROGRAM_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CreditProgram creditProgram;

    @Column(name = "AMOUNT", precision = 19, scale = 2)
    private BigDecimal amount;

    @NotNull
    @Column(name = "PERCENT_", nullable = false)
    private Double percent;

    @Min(message = "{msg://com.company.creditapplication.entity/Offer.numberMonths.validation.Min}", value = 6)
    @Column(name = "NUMBER_MONTHS", nullable = false)
    @NotNull
    private Integer numberMonths;

    @Composition
    @OneToMany(mappedBy = "offer")
    private List<PaymentShedule> paymentShedule;

    @JoinColumn(name = "CREDIT_ID")
    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    private Credit credit;

    public void setPaymentShedule(List<PaymentShedule> paymentShedule) {
        this.paymentShedule = paymentShedule;
    }

    public List<PaymentShedule> getPaymentShedule() {
        return paymentShedule;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getNumberMonths() {
        return numberMonths;
    }

    public void setNumberMonths(Integer numberMonths) {
        this.numberMonths = numberMonths;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CreditProgram getCreditProgram() {
        return creditProgram;
    }

    public void setCreditProgram(CreditProgram creditProgram) {
        this.creditProgram = creditProgram;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}