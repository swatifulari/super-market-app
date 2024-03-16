/**
 * 
 */
package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.models.Product;

/**
 * 
 */
@Service
public class ProductService {
	private List<Product> products = new ArrayList<Product>();

	/**
	 * @return the productList
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<Product> productList) {
		this.products = productList;
	}

	public void generateDummyData() {
		products.add(new Product("A", 40, 3, 70));
		products.add(new Product("B", 10, 2, 15));
		products.add(new Product("C", 30));
		products.add(new Product("D", 25));
	}

}
