package com.example.customer.domain;

import java.util.Optional;

public interface CustomerService {

	public Optional<CustomerEntity> findCustomerById(Long id);

	public CustomerResponse saveCustomer(CustomerEntity customer);
}
