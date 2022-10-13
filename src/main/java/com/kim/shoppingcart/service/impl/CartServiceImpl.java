package com.kim.shoppingcart.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.kim.shoppingcart.model.Cart;
import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.CartRepository;
import com.kim.shoppingcart.repository.ProductRepository;
import com.kim.shoppingcart.service.CartService;

import jakarta.persistence.EntityManager;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;
	
	@Autowired 
	EntityManager entityManager;

	public CartServiceImpl(CartRepository cartRepo) {
		super();
		this.cartRepo = cartRepo;
	}

	@Override
	public Optional<Cart> findById(Integer id) {
		return cartRepo.findById(id);
	}
	
	
	
	
	
}