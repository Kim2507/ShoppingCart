package com.kim.shoppingcart.serviceImplTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kim.shoppingcart.model.Cart;
import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.CartRepository;
import com.kim.shoppingcart.repository.ProductRepository;
import com.kim.shoppingcart.repository.UserRepository;
import com.kim.shoppingcart.service.impl.CartServiceImpl;
import com.kim.shoppingcart.service.impl.ProductServiceImpl;

import jakarta.persistence.EntityManager;

@SpringBootTest
public class CartServiceImplTest {
	@Autowired
	CartServiceImpl cartService;
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	ProductServiceImpl productService;
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	EntityManager entityManager;
	@Autowired
	UserRepository userRepo;
	
//	//succeed
	@Test 
	public void testAddProductToCart() {
		ProductDetails p = productRepo.findById((long) 1).get();
		Cart cart = cartService.findByUserID((long) 1);
		List<ProductDetails> productList = new ArrayList<>();
		productList.add(p);
		productList.add(p);
		productList.add(p);
		cart.setProductsList(productList);
		cartRepo.save(cart);
		
		assertNotNull(cartRepo.findById((long) 1).get());
	}
	
	@Test 
	public void getCartByUserId() {
		//Cart cart = cartService.findByUserID((long) 1);
		assertNotNull(cartService.findByUserID((long) 1));
	}
	
	
	
	
}
