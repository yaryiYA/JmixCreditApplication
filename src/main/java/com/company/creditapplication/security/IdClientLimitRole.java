package com.company.creditapplication.security;



import com.company.creditapplication.entity.Client;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "id-limit", code = "id-limit")
public interface IdClientLimitRole {


    @JpqlRowLevelPolicy(entityClass = Client.class, where = "{E}.createdBy = :current_user_username")
    void client();
}