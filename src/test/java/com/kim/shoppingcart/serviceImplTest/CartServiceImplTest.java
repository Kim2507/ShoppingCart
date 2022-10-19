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
	@Test // save black tea product to cart then save cart to database
	public void testSaveCart() {
		ProductDetails p = productService.findById((long) 1);
		Cart cart = cartService.findByUserID((long) 1);
		List<ProductDetails> productList = new ArrayList<>();
		productList.add(p);
		productList.add(p);
		productList.add(p);
		cart.setProductsList(productList);
		cartService.save(cart);
		assertNotNull(cartService.findByUserID((long) 1));
	}
	
	@Test
	public void testFindById() {
		Cart actual = cartService.findById((long) 1);
		Cart expected = new Cart();
		expected.setId((long) 1);
		assertEquals(expected.getId(),actual.getId());
		
	}
	
	@Test // getting cart with id 1
	public void getFindByUserId() {
		assertNotNull(cartService.findByUserID((long) 1));
	}
	
	
	
	
}
