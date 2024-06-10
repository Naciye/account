package com.aydin.account.dto;

import com.aydin.account.model.Account;

import java.util.HashSet;
import java.util.Set;

public class CustomerDto {
    private String id;
    private String name;
    private String surName;
    private Set<CustomerAccountDto> accounts;

    public CustomerDto(String id, String name, String surName, Set<CustomerAccountDto> accounts) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.accounts = accounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Set<CustomerAccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<CustomerAccountDto> accounts) {
        this.accounts = accounts;
    }
}
