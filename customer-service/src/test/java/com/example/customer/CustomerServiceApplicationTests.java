package com.example.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.customer.controller.CustomerController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceApplicationTests {
	@Autowired
	private CustomerController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
