package com.kim.shoppingcart.service;

import java.math.BigDecimal;
import java.util.Map;

import com.kim.shoppingcart.model.ProductDetails;

public interface CartService {
	void addProduct(ProductDetails product);

    void removeProduct(ProductDetails product);

    Map<ProductDetails, Integer> getProductsInCart();

    

}
