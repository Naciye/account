package com.aydin.account.dto;

import com.aydin.account.model.Customer;
import com.aydin.account.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class AccountDto {
    private String id;
    private BigDecimal balance ;
    private LocalDateTime creationDate;
    private AccountCustomerDto customer;
    private Set<TransactionDto> transaction;

    public AccountDto(String id, BigDecimal balance, LocalDateTime creationDate, AccountCustomerDto accountCustomerDto, Set<TransactionDto> collect) {
        this.id = id;
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = accountCustomerDto;
        this.transaction = collect;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public AccountCustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(AccountCustomerDto customer) {
        this.customer = customer;
    }

    public Set<TransactionDto> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<TransactionDto> transaction) {
        this.transaction = transaction;
    }
}
