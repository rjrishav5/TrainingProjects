package com.nagarro.exittest;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class ExittestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExittestApplication.class, args);
	}

}
