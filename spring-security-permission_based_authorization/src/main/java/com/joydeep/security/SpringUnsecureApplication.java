package com.joydeep.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SpringUnsecureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUnsecureApplication.class, args);
	}

}
