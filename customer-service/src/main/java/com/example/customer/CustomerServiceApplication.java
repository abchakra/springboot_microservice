package com.example.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.customer.domain.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	

	@Bean

	CommandLineRunner runner() {
		return args -> {
			// Add owner objects and save these to db
//			Owner owner1 = new Owner("John", "Johnson");
//			Owner owner2 = new Owner("Mary", "Robinson");
//			orepository.save(owner1);
//			orepository.save(owner2);

			// Add car object with link to owners and save these to db.
		};
	}
}
