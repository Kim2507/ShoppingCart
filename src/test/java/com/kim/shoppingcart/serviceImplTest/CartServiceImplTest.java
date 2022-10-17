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
		Cart cart = new Cart();
		List<ProductDetails> productList = new ArrayList<>();
		ProductDetails p = productRepo.getReferenceById(1);
		productList.add(p);
		productList.add(p);
		productList.add(p);
		cart.setProductsList(productList);
		cart.setUserID(userRepo.getReferenceById((long) 2));
//		System.out.println(cart.getProductMap().toString().toString());
//		System.out.println(cart.getPreTax());
//		System.out.println(cart.getTotal());
		cartRepo.save(cart);
	}
	
	@Test 
	public void getCartByUserId() {
		//Cart cart = cartService.findByUserID((long) 1);
		assertNotNull(cartService.findByUserID((long) 2));
	}
	
	
	
	
}
