package com.example.customer.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.domain.CustomerEntity;
import com.example.customer.domain.CustomerResponse;
import com.example.customer.domain.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<CustomerEntity> findById(@PathVariable Long id) {
		Optional<CustomerEntity> customer = customerService.findCustomerById(id);
		if (!customer.isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(customer.get());
	}

	@PostMapping("/")
	public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerEntity customer) {
		CustomerResponse customerResponse = customerService.saveCustomer(customer);
		log.info("New Customer Id " + customerResponse.getId());
		return ResponseEntity.ok(customerResponse);
	}
}
