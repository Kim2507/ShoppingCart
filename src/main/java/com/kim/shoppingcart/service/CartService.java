package com.kim.shoppingcart.service;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.kim.shoppingcart.model.Cart;


public interface CartService {
	Cart findById(Long id);
	
    Cart findByUserID(Long id);

	void save(Cart cart);
	
	
    

}
