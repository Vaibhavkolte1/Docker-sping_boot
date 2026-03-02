package com.college.e_commarce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class ECommarceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommarceApplication.class, args);
	}

}
