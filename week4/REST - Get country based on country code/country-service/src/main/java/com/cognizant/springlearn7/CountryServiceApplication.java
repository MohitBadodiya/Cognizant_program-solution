package com.cognizant.springlearn7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country.xml")
public class CountryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CountryServiceApplication.class, args);
	}
}
