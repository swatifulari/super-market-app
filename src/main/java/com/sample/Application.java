package com.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sample.service.ProductService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan("com.sample")
public class Application {
	
	@Autowired
	ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init() {
		productService.generateDummyData();
	}
}
