package com.sample.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.models.Product;
import com.sample.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * API to retrieve available list of Products
	 * @return
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProductsList() {
		System.out.println("products endpoint");
		return productService.getProducts();
	}

	/**
	 * API which can help admin user to add new product
	 * @param addProducts
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> addProduct(@RequestBody List<Product> addProducts) {
		if (productService.getProducts().containsAll(addProducts)) {
			return new ResponseEntity<>("Product Already Exists", HttpStatus.BAD_REQUEST);
		} else {
			productService.getProducts().addAll(addProducts);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}

}
