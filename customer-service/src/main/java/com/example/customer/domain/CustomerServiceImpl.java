package com.example.customer.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public Optional<CustomerEntity> findCustomerById(Long id) {
		return repository.findById(id);
	}

	@Override
	public CustomerResponse saveCustomer(CustomerEntity customer) {
		System.out.println("");
		repository.save(customer);
		log.info("Saved new customer with id: {}", customer.getId());
		return new CustomerResponse(customer.getId());

	}

}
