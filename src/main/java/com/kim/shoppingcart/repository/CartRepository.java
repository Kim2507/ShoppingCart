package com.kim.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kim.shoppingcart.model.Cart;
import com.kim.shoppingcart.model.OrderDetails;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
