package com.kim.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kim.shoppingcart.model.Cart;
import com.kim.shoppingcart.service.CartService;

@Repository
//@Transactional
public interface CartRepository extends JpaRepository<Cart, Long>{

	//@Query("SELECT * FROM shoppingcart.cart as c WHERE c.user_id = ?1")
	//List<Cart> findByUserId(Long userId);
	Cart findByUserId(Long userId);
	//CRUD 
}
