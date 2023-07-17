package com.company.creditapplication.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "cap_PaymentShedule", indexes = {
        @Index(name = "IDX_CAP_PAYMENTSHEDULE_OFFER", columnList = "OFFER_ID")
})
@JmixEntity
@Entity(name = "cap_PaymentShedule")
public class PaymentShedule extends BaseEntity {


    @NotNull
    @Column(name = "PAYMANT_DATE", nullable = false)
    private LocalDate paymantDate;

    @Column(name = "PERCENT_", precision = 19, scale = 2)
    private BigDecimal percent;

    @Column(name = "LOAN_BODY", nullable = false, precision = 19, scale = 2)
    @NotNull
    private BigDecimal loanBody;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "OFFER_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Offer offer;

    public void setPaymantDate(LocalDate paymantDate) {
        this.paymantDate = paymantDate;
    }

    public LocalDate getPaymantDate() {
        return paymantDate;
    }


    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public BigDecimal getLoanBody() {
        return loanBody;
    }

    public void setLoanBody(BigDecimal loanBody) {
        this.loanBody = loanBody;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

}