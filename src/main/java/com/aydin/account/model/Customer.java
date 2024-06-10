package com.aydin.account.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;
    private String surName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)   // customer çekildiğinde customer a ait accountları da çekebileyim.

    private Set<Account> accounts;

    public Customer(String id, String name, String surName, Set<Account> accounts) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.accounts = accounts;
    }

    public Customer() {}

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

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(surName, customer.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName);
    }
}
