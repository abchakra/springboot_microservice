package com.example.gallery;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.gallery.controllers.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebClientIntegrationTests {

	@MockBean
	HomeController controller;

	@Autowired
	private WebTestClient client;

	@Before
	public void setup() {
		when(controller.getImagesFor()).thenReturn(new ArrayList<Object>());

	}

	@Test
	public void testGalleryGetResource() {
		client.get().uri("/1").accept(APPLICATION_JSON).exchange().expectStatus().isOk();

	}

	@Test
	public void testGalleryHome() throws Exception {
		client.get().uri("/").accept(APPLICATION_JSON).exchange().expectStatus().isOk();
	}

}