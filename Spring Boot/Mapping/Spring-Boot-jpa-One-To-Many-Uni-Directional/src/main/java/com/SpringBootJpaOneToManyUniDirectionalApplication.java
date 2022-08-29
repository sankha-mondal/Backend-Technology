package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaOneToManyUniDirectionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaOneToManyUniDirectionalApplication.class, args);
		System.out.println("OneToMany Uni Directional mapping Running on port number 9090...");
	}

}


	/**
	 *   Dependencies: jpa, web, devtools, mysql
	 *   Run as: Java Application
	 */


