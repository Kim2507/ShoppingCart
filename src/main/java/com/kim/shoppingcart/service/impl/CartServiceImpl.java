package com.kim.shoppingcart.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.ProductRepository;
import com.kim.shoppingcart.service.CartService;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {

	private final ProductRepository productRepo;

	private Map<ProductDetails, Integer> products = new HashMap<>();

	@Autowired
	public CartServiceImpl(ProductRepository productRepository) {
		this.productRepo = productRepository;
	}
	
	@Override
	public void addProduct(ProductDetails product) {
		if (products.containsKey(product)) {
			products.replace(product, products.get(product) + 1);
		} else {
			products.put(product, 1);
		}
	}

	
	@Override
	public void removeProduct(ProductDetails product) {
		if (products.containsKey(product)) {
			if (products.get(product) > 1)
				products.replace(product, products.get(product) - 1);
			else if (products.get(product) == 1) {
				products.remove(product);
			}
		}
	}

	@Override
	public Map<ProductDetails, Integer> getProductsInCart() {
		return Collections.unmodifiableMap(products);
	}

}
