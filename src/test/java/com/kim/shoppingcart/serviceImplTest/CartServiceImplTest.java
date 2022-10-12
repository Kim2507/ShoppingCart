package com.kim.shoppingcart.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.service.impl.CartServiceImpl;
import com.kim.shoppingcart.service.impl.ProductServiceImpl;

@SpringBootTest
public class CartServiceImplTest {
	@Autowired
	CartServiceImpl cartService;
	
	@Autowired
	ProductServiceImpl productService;
	
	@Test
	public void testGetProducts() {
		Optional<ProductDetails> btO = productService.findById(1);
		ProductDetails bt = btO.get();
		Optional<ProductDetails> gtO = productService.findById(2);
		ProductDetails gt = gtO.get();
		ProductDetails btE = new ProductDetails();
		btE.setName("black tea");
		ProductDetails gtE = new ProductDetails();
		gtE.setName("green tea");
		assertEquals(btE.getName(),bt.getName());
		assertEquals(gtE.getName(),gt.getName());
	}
	
	@Test 
	public void testCart() {
		Optional<ProductDetails> btO = productService.findById(1);
		ProductDetails bt = btO.get();
		Optional<ProductDetails> gtO = productService.findById(2);
		ProductDetails gt = gtO.get();
		cartService.addProduct(gt);
		cartService.addProduct(gt);
		cartService.addProduct(bt);
		// above are one bt 2 gt 
		System.out.println(cartService.getProductsInCart().toString().toString());
		
	}
}
