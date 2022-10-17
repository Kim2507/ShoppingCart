package com.kim.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kim.shoppingcart.model.Cart;
import com.kim.shoppingcart.model.OrderDetails;
import com.kim.shoppingcart.service.CartService;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	//CRUD 
}
