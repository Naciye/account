package com.aydin.account.dto.converter;

import com.aydin.account.dto.AccountCustomerDto;
import com.aydin.account.dto.CustomerDto;
import com.aydin.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter customerAccountDtoConverter) {
        this.customerAccountDtoConverter = customerAccountDtoConverter;
    }

    public AccountCustomerDto convertToAccountCustomer(Customer customer) {

        if (customer == null) {
            return new AccountCustomerDto("", "", "");
        }
        return new AccountCustomerDto(customer.getId(), customer.getName(), customer.getSurName());
    }

    public CustomerDto convertToCustomerDto(Customer from) {

        return new CustomerDto(from.getId(), from.getName(), from.getSurName(),
                from.getAccounts().stream().map(customerAccountDtoConverter :: convert).collect(Collectors.toSet()));
    }
}
