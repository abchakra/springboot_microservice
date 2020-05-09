package com.example.customer.domain;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CustomerService {

	private final CustomerRepository customerRepository;

	public Optional<CustomerEntity> findById(Long id) {

		return customerRepository.findById(id);
	}
}
