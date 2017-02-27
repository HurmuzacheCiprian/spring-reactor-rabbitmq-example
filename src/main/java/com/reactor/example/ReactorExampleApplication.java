package com.reactor.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ReactorExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactorExampleApplication.class, args);
	}
}