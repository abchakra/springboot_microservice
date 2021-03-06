package com.example.gallery.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.gallery.entities.Gallery;

@RestController
@RequestMapping("/")
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	}

	@RequestMapping("/{id}")
	public Gallery getGallery(@PathVariable final int id) {
		// create gallery object
		LOGGER.info("Creating gallery object ... ");
		Gallery gallery = new Gallery();
		gallery.setId(id);

		// get list of available images
		List<Object> images = getImagesFor();
		gallery.setImages(images);

		LOGGER.info("Returning images ... ");
		return gallery;
	}

	public List<Object> getImagesFor() {
		return restTemplate.getForObject("http://image-service/images/", List.class);
	}

	// -------- Admin Area --------
	// This method should only be accessed by users with role of 'admin'
	// We'll add the logic of role based auth later
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}
}