package com.example.gallery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockIntegrationTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGalleryHome() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		assertEquals("Hello from Gallery Service running at port: null", content);
	}
	


}