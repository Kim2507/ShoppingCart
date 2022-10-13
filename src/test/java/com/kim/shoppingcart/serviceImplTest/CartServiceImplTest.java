package com.kim.shoppingcart.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kim.shoppingcart.model.Cart;
import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.CartRepository;
import com.kim.shoppingcart.repository.ProductRepository;
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
	
	
	
	@Test 
	public void testAddProductToCart() {
		Cart cart = new Cart();
		List<ProductDetails> productList = new ArrayList<>();
		ProductDetails p1 = productService.findById(1).get();
		ProductDetails p2 = productService.findById(2).get();
		productList.add(p2);
		productList.add(p2);
		productList.add(p2);
		productList.add(p2);
		cart.setId(18);
		cart.setProductsList(productList);
		System.out.println(cart.getProductMap().toString().toString());
		System.out.println(cart.getPreTax());
		System.out.println(cart.getTotal());
		cartRepo.save(cart);
	}
}
