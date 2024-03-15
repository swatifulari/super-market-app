package com.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperMarketController {

	@GetMapping("health")
	public String getAppHealth() {
		System.out.println("health endpoint");
		return "Application is healthy!";
	}
	
	

}
