package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/*----------------------- THIS IS THE MAIN FUNCTION FROM WHERE WE WILL RUN OUR SPRING APPLICATION--------------*/


@SpringBootApplication
public class Advancejava_assignment5 {
	

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	public static void main(String[] args) {
		
		
		SpringApplication.run(Advancejava_assignment5.class, args);
	
	
	}

}
