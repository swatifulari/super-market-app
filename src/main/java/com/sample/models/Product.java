/**
 * 
 */
package com.sample.models;

import java.util.Objects;

/**
 * 
 */
public class Product {
	private String productName;

	private double price;

	public Product(String productName, double price) {
		this.productName = productName;
		this.price = price;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Product product = (Product) o;
	    return Double.compare(product.price, price) == 0 &&
	            Objects.equals(productName, product.productName);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(productName, price);
	}


}
