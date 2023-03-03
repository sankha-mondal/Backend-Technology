package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FirstMicroServideClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMicroServideClientApplication.class, args);
		System.out.println("Eureka First client running on port number 8181");
	}

}
