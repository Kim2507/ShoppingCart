package com.kim.shoppingcart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kim.shoppingcart.model.Cart;
import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.CartRepository;
import com.kim.shoppingcart.repository.ProductRepository;
import com.kim.shoppingcart.service.impl.CartServiceImpl;
import com.kim.shoppingcart.service.impl.ProductServiceImpl;

@Controller
public class CartController {
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/shopping")
	public String showShopPage() {
		return "shopping";
	}
	
	@PostMapping("/addedBT")
	public String addBTToCart(Model mv) {
		//Pulling the existing cart from db
		Cart cart = cartRepo.findById(1).get();
		System.out.println(cart);
		// Add more products into the existing cart 
		cart.addProduct(productRepo.findById(1).get());
		System.out.println(productRepo.findById(1).get());
		mv.addAttribute("map",cart.getProductMap());
		cartRepo.save(cart);
		return "cart4";
	}
	
	@PostMapping("/addedGT")
	public void addGTToCart() {
		Cart cart = cartRepo.findById(1).get();
		cart.addProduct(productRepo.getReferenceById(2));
		cartRepo.save(cart);
	}
	
	
	@GetMapping("/showCart")
	@ResponseBody
	public String showCart(ModelAndView mv) {
		Cart cart = cartRepo.findById(1).get();
		mv.addObject("map",cart.getProductMap());
		return "cart4";
	}
	
	
}
