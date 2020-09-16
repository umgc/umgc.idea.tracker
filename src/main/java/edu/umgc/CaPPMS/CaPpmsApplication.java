package edu.umgc.CaPPMS;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CaPpmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaPpmsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Welcome to UMGC Capstone Project Proposal Management System");

		};
	}

}
