package com.kim.shoppingcart.serviceImplTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.ProductRepository;
import com.kim.shoppingcart.service.impl.ProductServiceImpl;
/* For Product it is using Rest Repository so get/post(Read, Create) method 
 * already supported by Spring Rest*/
@SpringBootTest
public class ProductServiceImplTest {
	
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ProductServiceImpl productService;
	

	
	@Test
	public void testFindById() {
		ProductDetails expected = new ProductDetails();
		ProductDetails actual = productService.findById((long) 1);
		expected.setName("Black Tea");
		assertEquals(expected.getName(),actual.getName());
		
	}
	
	@Test // from service
	public void testFindByName() {
		ProductDetails p = productService.findByName("Black Tea");
		assertEquals("Black Tea", p.getName());
	}

}
