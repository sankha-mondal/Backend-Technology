package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Student;

@SpringBootApplication
public class SpringBootJpaOneToOneReUniDApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaOneToOneReUniDApplication.class, args);
		System.out.println("Server up!... Running on port number 8383...");
		
	}

}


	/**
	 *   Dependencies: jpa, JDBC, web, devtools, mysql
	 *   Run as: Java Application
	 */


