package com.kim.shoppingcart.serviceImplTest;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kim.shoppingcart.model.OrderDetails;
import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.OrderRepository;
import com.kim.shoppingcart.repository.ProductRepository;
import com.kim.shoppingcart.service.ProductService;
import com.kim.shoppingcart.service.impl.CartServiceImpl;
import com.kim.shoppingcart.service.impl.OrderServiceImpl;

@SpringBootTest
public class OrderServiceImplTest {
	@Autowired
	OrderServiceImpl orderService;
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	CartServiceImpl cartService;
	
	@Autowired
	ProductRepository productRepo;
	
	@Test
	public void testPlaceOrder() {
		ProductDetails p1 = productRepo.findById(1).get();
		ProductDetails p2 = productRepo.findById(2).get();
		Set<ProductDetails> products = new HashSet<ProductDetails>();
		products.add(p1);
		products.add(p2);
		OrderDetails order = new OrderDetails();
		OrderDetails order1 = new OrderDetails();
		order.setProductsSet(products);
		order1.setProductsSet(products);
		orderRepo.save(order);
		orderRepo.save(order1);
		
		
		
		
		
		
		
	}
	
//	@Test
//	public void testGetOrder() {
//		OrderDetails order = orderService.findById(13).get();
//		System.out.println(order.getProducts().toString().toString());
//	}

}
