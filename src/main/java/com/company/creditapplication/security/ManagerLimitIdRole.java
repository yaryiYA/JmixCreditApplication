package com.company.creditapplication.security;



import com.company.creditapplication.entity.*;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "id-limit", code = "id-limit")
public interface ManagerLimitIdRole {


    @JpqlRowLevelPolicy(entityClass = Client.class,
            where = "{E}.createdBy = :current_user_username")
    void client();

    @JpqlRowLevelPolicy(entityClass = Bank.class,
            where = "{E}.createdBy = :current_user_username")
    void bank();


    @JpqlRowLevelPolicy(entityClass = CreditProgram.class,
            where = "{E}.createdBy = :current_user_username")
    void creditProgram();

    @JpqlRowLevelPolicy(entityClass = Offer.class,
            where = "{E}.createdBy = :current_user_username")
    void offer();

    @JpqlRowLevelPolicy(entityClass = Credit.class,
            where = "{E}.createdBy = :current_user_username")
    void credit();
}