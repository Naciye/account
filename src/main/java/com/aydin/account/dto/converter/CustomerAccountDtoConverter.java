package com.aydin.account.dto.converter;


import com.aydin.account.dto.CustomerAccountDto;
import com.aydin.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public CustomerAccountDto convert(Account account){
        return new CustomerAccountDto(Objects.requireNonNull(account.getId()),
                account.getBalance(),
                account.getCreationDate(),
                account.getTransaction()
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toSet())
                );

    }


}
