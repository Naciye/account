package com.aydin.account.dto.converter;

import com.aydin.account.dto.AccountDto;
import com.aydin.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account account) {
        return  new AccountDto(account.getId(),
                account.getBalance(),
                account.getCreationDate(),
                customerDtoConverter.convertToAccountCustomer(account.getCustomer()),
                Objects.requireNonNull(account.getTransaction())
                        .stream()
                        .map(transactionDtoConverter ::convert).collect(Collectors.toSet()));
    }
}
