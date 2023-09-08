package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PaytmServiceApplication {     

	public static void main(String[] args) {
		SpringApplication.run(PaytmServiceApplication.class, args);
		System.out.println("Paytm service up on port number 8484...");
	}

	// Bcoz Paytm-Service going to call Account-Service
	@Bean					// This method is responsible for creating the object but maintain by container.			
	@LoadBalanced				// @LoadBalanced is responsible to call microservice by name. 
	public RestTemplate restTemplate() {	 
		return new RestTemplate();
	}
}
