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

	
	@Bean									// This method is responsible to 
	@LoadBalanced				// This annotation is responisble to call micro service by name 
	public RestTemplate restTemplate() {	// create the object but maintain by container. 
		return new RestTemplate();
	}
}
