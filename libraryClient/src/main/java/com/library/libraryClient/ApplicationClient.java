package com.library.libraryClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.library.libraryClient.clients", "com.library.libraryClient.controllers", "com.library.libraryClient.config"})
public class ApplicationClient {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationClient.class, args);
	}
}
