package com.roche.iconnect.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.roche")
public class PartyManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartyManagerApplication.class, args);
	}

}

