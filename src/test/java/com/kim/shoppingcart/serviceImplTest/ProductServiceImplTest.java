package com.kim.shoppingcart.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.ProductRepository;
import com.kim.shoppingcart.service.impl.ProductServiceImpl;

@SpringBootTest
public class ProductServiceImplTest {
	@Autowired
	ProductServiceImpl productService;
	
	@Autowired
	ProductRepository productRepo;
	
	@Test
	public void testGetProducts() {
		//Optional<ProductDetails> btO = productService.findById(1);
		ProductDetails bt = productRepo.findById(1).get();
		//Optional<ProductDetails> gtO = productService.findById(2);
		ProductDetails gt = productRepo.findById(2).get();
		ProductDetails btE = new ProductDetails();
		btE.setName("black tea");
		ProductDetails gtE = new ProductDetails();
		gtE.setName("green tea");
		assertEquals(btE.getName(),bt.getName());
		assertEquals(gtE.getName(),gt.getName());
		
		
	}
	

}
