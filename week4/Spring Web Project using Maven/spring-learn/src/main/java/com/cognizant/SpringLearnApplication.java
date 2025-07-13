package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Application started on port: " + environment.getProperty("server.port"));
	}
}
