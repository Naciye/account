package com.aydin.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class CustomerAccountDto {

    private String id;
    private BigDecimal balance ;
    private LocalDateTime creationDate;
    private Set<TransactionDto> transactions;

    public CustomerAccountDto(String id, BigDecimal balance, LocalDateTime creationDate, Set<TransactionDto> transactions) {
        this.id = id;
        this.balance = balance;
        this.creationDate = creationDate;
        this.transactions = transactions;
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

    public Set<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}
