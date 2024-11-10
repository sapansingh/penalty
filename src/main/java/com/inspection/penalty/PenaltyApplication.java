package com.inspection.penalty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class PenaltyApplication {			
	public static void main(String[] args) {
		SpringApplication.run(PenaltyApplication.class, args);
	}

	
}
