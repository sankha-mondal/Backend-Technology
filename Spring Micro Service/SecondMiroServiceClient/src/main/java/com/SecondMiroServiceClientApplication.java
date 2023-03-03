package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SecondMiroServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondMiroServiceClientApplication.class, args);
		System.out.println("Second micro service client running on port number 8282");
	}

}
