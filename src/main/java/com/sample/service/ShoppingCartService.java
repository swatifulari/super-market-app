package com.sample.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sample.models.ErrorMessage;
import com.sample.models.Product;
import com.sample.models.ShoppingCart;

@Service
public class ShoppingCartService {

	@Autowired
	private ProductService productService;

	/**
	 * Creates cart order calculates total price after applying offers.
	 * 
	 * Handles the business logic of the promotional offers.
	 * 
	 * @param orders
	 * @return
	 */
	public ResponseEntity<?> updateCartWithTotalPrice(ShoppingCart orders) {

		double totalPrice = 0.0;
		List<Product> availableProductsList = productService.getProducts();
		if (productService.getProducts().containsAll(orders.getCartItems())) {
			for (Iterator<Product> itr = orders.getCartItems().iterator(); itr.hasNext();) {
				Product cartProduct = itr.next();
				for (Iterator<Product> products = availableProductsList.iterator(); products.hasNext();) {
					Product availableProduct = products.next();
					if (cartProduct.equals(availableProduct)) {
						totalPrice += getTotalPriceWithOffer(cartProduct.getTotalNumberOfItems(),
								availableProduct.getPrice(), availableProduct.getPromoPrice(),
								availableProduct.getPromoCount());
						orders.setCartTotal(totalPrice);
					}
				}
			}
		} else {
			ErrorMessage errorMessage = new ErrorMessage("Product  is not available in market. Choose Valid Product");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
		}

		return ResponseEntity.ok().body(orders);

	}

	/**
	 * Method to get total item price by applying offer.
	 * 
	 * @param unitsToBuy
	 * @param perUnitPrice
	 * @param promoPrice
	 * @param promoCount
	 * @return
	 */
	public double getTotalPriceWithOffer(int unitsToBuy, double perUnitPrice, double promoPrice, int promoCount) {
		double totalPriceWithOffer;

		if (promoCount != 0 && unitsToBuy >= promoCount) {
			// Calculate the total price with offer
			totalPriceWithOffer = promoPrice * (unitsToBuy / promoCount) + (unitsToBuy % promoCount) * perUnitPrice;
		} else {
			// Calculate the total price without offer
			totalPriceWithOffer = perUnitPrice * unitsToBuy;
		}
		return totalPriceWithOffer;
	}

}
