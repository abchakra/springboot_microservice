package com.example.customer;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.customer.domain.CustomerEntity;
import com.example.customer.domain.CustomerResponse;
import com.example.customer.domain.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CustomerAPITests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void findById() throws Exception {
		// given
		CustomerEntity customer1 = new CustomerEntity(1, "John", "Smith", "johnsmith@example.com", "+4912345678910");

		Optional<CustomerEntity> customerOpt = Optional.ofNullable(customer1);
		when(customerService.findCustomerById(1L)).thenReturn(customerOpt);
		// when + then
		this.mockMvc.perform(get("/api/v1/customers/1")).andExpect(status().isOk());
	}

	@Test
	public void createCustomer() throws Exception {
		// given
		CustomerEntity customer1 = new CustomerEntity(1, "John", "Smith", "johnsmith@example.com", "+4912345678910");

		when(customerService.saveCustomer(customer1)).thenReturn(new CustomerResponse(0L));

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customers/").content(asJsonString(customer1))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
