package com.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@GetMapping("health")
	public String getAppHealth() {
		return "Application is healthy!";
	}
	
}
