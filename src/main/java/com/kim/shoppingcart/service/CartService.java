package com.kim.shoppingcart.service;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.kim.shoppingcart.model.Cart;


public interface CartService {
	

	Optional<Cart> findById(Integer id);
	//@Query(value="SELECT * FROM shoppingcart1.cart WHERE userid_id = ?1")
    Cart findByUserID(Long id);
    

}
