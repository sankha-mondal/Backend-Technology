package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = "com.bean")
@EnableJpaRepositories(basePackages = "com.repository")
public class UserServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
			SpringApplication.run(UserServiceApplication.class, args);

		String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);

		// All default beans
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
		System.out.println("User service running on port number 8080...");
	}

}

	/**
	 *   Dependencies: jpa, JDBC, web, devtools, mysql, Eureka Client
	 *   Run as: Java Application
	 */



