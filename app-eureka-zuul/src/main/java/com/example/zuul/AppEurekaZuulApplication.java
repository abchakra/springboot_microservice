package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient 		// It acts as a eureka client
@EnableZuulProxy		// Enable Zuul

public class AppEurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppEurekaZuulApplication.class, args);
	}

}
