package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8181/first/sayHello

@RestController
@RequestMapping("first")
public class SampleController {

	@GetMapping(value = "sayHello")
	public String sayHello() {
		return "Welcome to Spring micro service with first client";
	}
}
