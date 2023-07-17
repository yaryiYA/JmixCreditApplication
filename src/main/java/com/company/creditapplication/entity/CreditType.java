package com.company.creditapplication.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum CreditType implements EnumClass<String> {

    MORTGAGE("mortgage"),
    AUTO_LOAN("autoLoan"),
    REFINANCING("refinancing");

    private String id;

    CreditType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CreditType fromId(String id) {
        for (CreditType at : CreditType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}