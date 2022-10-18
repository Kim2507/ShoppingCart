package com.kim.shoppingcart.service.impl;

import java.math.BigDecimal;

import java.util.*;


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
import com.kim.shoppingcart.repository.UserRepository;
import com.kim.shoppingcart.service.CartService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContexts;
import jakarta.persistence.Query;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;
	@Autowired
	UserRepository userRepo;
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

	@Override
	public Cart findByUserID(Long userId) {
		Query query = entityManager.createNativeQuery("SELECT * FROM shoppingcart.cart " +
               "WHERE userid_id = ?", Cart.class);
        
		//query = query.setParameter(1, userId);
		query.setParameter(1, userId);
		List<Cart> cart  = query.getResultList();//getSingleResult();
		//if(query.getSingleResult()==null) {
		if(cart.isEmpty()) {
			Cart cart2 = new Cart();
			cart2.setUserID(userRepo.findById(userId).get());
			cartRepo.save(cart2);
		}

        return (Cart)query.getSingleResult();
		
		
	}
	
	
	
	
	
}
