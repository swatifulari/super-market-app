package com.sample.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.models.Product;
import com.sample.models.ShoppingCart;
import com.sample.service.ProductService;

@RestController
public class ShoppingCartController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShoppingCart> createOrder(@RequestBody ShoppingCart orders) {
		
		
		List<Product> availableProductsList = productService.getProducts();
		if (productService.getProducts().containsAll(orders.getCartItems())) {
			System.out.println("Product is in the market");
			for (Iterator<Product> itr = orders.getCartItems().iterator(); itr.hasNext();) {
				Product cartProduct = itr.next();
				for (Iterator<Product> products = availableProductsList.iterator(); products.hasNext();) {
					Product availableProduct = products.next();
					System.out.println(availableProduct.getProductName());
					if (cartProduct.equals(availableProduct)) {
						System.out.println("Promo Count " + availableProduct.getPromoCount());
						System.out.println("Promo Price " + availableProduct.getPromoPrice());
						double totalPrice = getDiscountedPrice(cartProduct.getTotalNumberOfItems(),
								availableProduct.getPrice(), availableProduct.getPromoPrice(),
								availableProduct.getPromoCount());
						orders.setCartTotal(totalPrice);
					}
				}
			}
		} else {
//			responseEntity = new ResponseEntity<>("Product " + cartProduct.getProductName()
//			+ " is not available in market. Choose Valid Product", HttpStatus.BAD_REQUEST);

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		return ResponseEntity.ok().body(orders);
	}

	public double getDiscountedPrice(int unitsToBuy, double perUnitPrice, double promoPrice, int promoCount) {
		double totalPriceWithOffer;

		if (promoCount != 0 && unitsToBuy >= promoCount) {
			// Calculate the total price with offer
			totalPriceWithOffer = promoPrice * (unitsToBuy / promoCount) + (unitsToBuy % promoCount) * perUnitPrice;
		} else {
			// Calculate the total price without offer
			totalPriceWithOffer = perUnitPrice * unitsToBuy;
		}

		System.out.println("Offer provided by the shop: " + totalPriceWithOffer);
		return totalPriceWithOffer;
	}

}