package com.aydin.account.service;

import com.aydin.account.dto.CustomerDto;
import com.aydin.account.dto.converter.CustomerDtoConverter;
import com.aydin.account.exception.CustomerNotFoundException;
import com.aydin.account.model.Customer;
import com.aydin.account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CustomerServiceTest {

    private CustomerService customerService;
    private  CustomerRepository customerRepository;
    private  CustomerDtoConverter customerDtoConverter;

    @BeforeEach
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        customerDtoConverter = mock(CustomerDtoConverter.class);
        customerService = new CustomerService(customerRepository, customerDtoConverter);

    }

    @Test
    public void findCustomerById_whenCustomerIdExists_shouldReturnCustomer() {

        Customer customer = new Customer("id", "name", "surname", Set.of());
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));

        Customer foundCustomer = customerService.findCustomerById("id");

        assertEquals(foundCustomer, customer);
    }

    @Test
    public void findCustomerById_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException() {

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.findCustomerById("id"));

    }

    @Test
    public void getCustomerById_whenCustomerExists_shouldReturnCustomer() {
        Customer customer = new Customer("id", "name", "surname", Set.of());
        CustomerDto customerDto = new CustomerDto("id", "name", "surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Mockito.when(customerDtoConverter.convertToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result = customerService.getCustomerById("id");
        assertEquals(result, customerDto);

    }

    @Test
    public void getCustomerById_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException() {
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById("id"));

        Mockito.verifyNoInteractions(customerDtoConverter);  // converter' in hiç bir metotdu çagrilmasin
    }



}