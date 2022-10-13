package com.kim.shoppingcart.service;


import java.util.Optional;
import com.kim.shoppingcart.model.Cart;


public interface CartService {
	

	Optional<Cart> findById(Integer id);

    

}
