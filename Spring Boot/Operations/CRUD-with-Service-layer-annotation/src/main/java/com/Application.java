package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("CRUD with @Service layer annotation...\nServer running on port number 9090...");
	}

}


	/**
	 *   Dependencies: jpa, web, devtools, mysql, validation
	 *   Run as: Java Application
	 */


