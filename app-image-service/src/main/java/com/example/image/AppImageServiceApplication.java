package com.example.image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppImageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppImageServiceApplication.class, args);
	}

}
