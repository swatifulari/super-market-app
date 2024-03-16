package com.sample.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingCart {
	
	@JsonProperty("cartItems")
	private List <Product> cartItems;
	
	 
	@JsonProperty("cartTotal")
	private double cartTotal;

	/**
	 * @return the cartItems
	 */
	public List<Product> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<Product> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * @return the cartTotal
	 */
	public double getCartTotal() {
		return cartTotal;
	}

	/**
	 * @param cartTotal the cartTotal to set
	 */
	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}
	
	

}
