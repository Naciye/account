package com.aydin.account;

import com.aydin.account.model.Customer;
import com.aydin.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String ... args) throws Exception{
		Customer customer = customerRepository.save(new Customer( "","Jack", "Bauer", new HashSet<>()));
		System.out.println("customer::" + customer.getId());


	}

}
