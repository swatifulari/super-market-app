/**
 * 
 */
package com.sample.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 */
public class Product {

	@JsonProperty("productName")
	private String productName;

	@JsonProperty("price")
	private double price;

	@JsonProperty("promoCount")
	private int promoCount;

	@JsonProperty("promoPrice")
	private double promoPrice;

	@JsonProperty("totalNumberOfItems")
	private int totalNumberOfItems;

	/**
	 * @return the totalNumberOfItems
	 */
	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}

	/**
	 * @param totalNumberOfItems the totalNumberOfItems to set
	 */
	public void setTotalNumberOfItems(int totalNumberOfItems) {
		this.totalNumberOfItems = totalNumberOfItems;
	}

	/**
	 * @return the promoCount
	 */
	public int getPromoCount() {
		return promoCount;
	}

	/**
	 * @param promoCount the promoCount to set
	 */
	public void setPromoCount(int promoCount) {
		this.promoCount = promoCount;
	}

	/**
	 * @return the promoPrice
	 */
	public double getPromoPrice() {
		return promoPrice;
	}

	/**
	 * @param promoPrice the promoPrice to set
	 */
	public void setPromoPrice(double promoPrice) {
		this.promoPrice = promoPrice;
	}

	public Product(String productName, double price) {
		this.productName = productName;
		this.price = price;
	}

	public Product(String productName, double price, int promoCount, double promoPrice) {
		this.productName = productName;
		this.price = price;
		this.promoCount = promoCount;
		this.promoPrice = promoPrice;
	}

	@JsonCreator
	public Product(@JsonProperty("productName") String productName, @JsonProperty("price") double price,
			@JsonProperty("totalNumberOfItems") int totalNumberOfItems) {
		this.productName = productName;
		this.price = price;
		this.totalNumberOfItems = totalNumberOfItems;
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
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product) o;
		return Double.compare(product.price, price) == 0 && Objects.equals(productName, product.productName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productName, price);
	}

}
