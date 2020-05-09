package com.example.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.customer.domain.CustomerEntity;
import com.example.customer.domain.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerJPATests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	CustomerRepository repository;

	@Test
	public void testCreateCustomer() throws Exception {
		CustomerEntity customer1 = new CustomerEntity(1, "John", "Smith", "johnsmith@example.com", "+4912345678910");

		entityManager.persistAndFlush(customer1);

		assertThat(customer1.getId()).isNotNull();

		Iterable<CustomerEntity> customers = repository.findAll();
//
		assertThat(customers).hasSize(1).contains(customer1);
	}

	@Test
	public void testDeleteCustomer() throws Exception {

		entityManager
				.persistAndFlush(new CustomerEntity(1, "John", "Smith", "johnsmith@example.com", "+4912345678910"));
		entityManager.persistAndFlush(new CustomerEntity(2, "Max", "Sam", "maxsam@example.com", "+49787878788"));
		Iterable<CustomerEntity> customers = repository.findAll();

		assertThat(customers).hasSize(2);

		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
	}

}
