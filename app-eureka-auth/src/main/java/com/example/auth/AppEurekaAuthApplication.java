package com.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.auth.entity.UserEntity;
import com.example.auth.entity.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class AppEurekaAuthApplication {

	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(AppEurekaAuthApplication.class, args);
	}

	@Bean

	CommandLineRunner runner() {
		return args -> {

			// username: user password: user
			urepository.save(
					new UserEntity("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			// username: admin password: admin
			urepository.save(
					new UserEntity("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
		};
	}

}
