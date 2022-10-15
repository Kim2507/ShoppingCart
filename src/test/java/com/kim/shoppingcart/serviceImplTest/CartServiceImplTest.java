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
	
	
	//succeed
	@Test 
	public void testAddProductToCart() {
		Cart cart = new Cart();
		Set<ProductDetails> productList = new HashSet<>();
		ProductDetails p = new ProductDetails("Black Tea","desc",5.5,8);
		productRepo.save(p);
		productList.add(p);
		productList.add(p);
		productList.add(p);
		cart.setProductsList(productList);
		System.out.println(cart.getProductMap().toString().toString());
		System.out.println(cart.getPreTax());
		System.out.println(cart.getTotal());
		cartRepo.save(cart);
	}
	
//	@Test 
//	public void getListCart() {
//		Cart cart = cartRepo.findById(19).get();
//		System.out.println(cart.getProductsList().toString().toString());
//	}
}
