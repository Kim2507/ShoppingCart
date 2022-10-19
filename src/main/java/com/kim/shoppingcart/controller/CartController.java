package com.kim.shoppingcart.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kim.shoppingcart.model.Cart;
import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.model.User;
import com.kim.shoppingcart.repository.CartRepository;
import com.kim.shoppingcart.repository.ProductRepository;
import com.kim.shoppingcart.security.CustomUserDetailsService;
import com.kim.shoppingcart.service.impl.CartServiceImpl;
import com.kim.shoppingcart.service.impl.ProductServiceImpl;
import com.kim.shoppingcart.service.impl.UserServiceImpl;

@Controller
public class CartController {
	
	@Autowired
	CartServiceImpl cartService;
	@Autowired
	ProductServiceImpl productService;
	
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/shopping")
	public String showShopPage() {
		return "shopping";
	}
	
	public User gettingAuthentication() {
		// get the ID of the authenticated user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		// Find user by email
		User user = userService.findUserByEmail(userName);
		return user;
	}
	
	@PostMapping("/addedBT")
	public String addBTToCart(Model model) {
		User user = gettingAuthentication();
		// Get user id
		Long userId = user.getId();
		//Find user cart by user id
		Cart cart = cartService.findByUserID(userId);
		System.out.println(cart);
		//Product
		ProductDetails product = productService.findById((long) 1);
		//Add product to cart
        cart.addProduct(product);
        System.out.println(cart.getProductCounter());
        System.out.println(cart.getPreTaxPrice());
        System.out.println(cart.getTotalPrice());
		model.addAttribute("cart",cart);
		model.addAttribute("product",product);
		cartService.save(cart);
		System.out.println("checking +");
		return "cart4";
	}
	
	@GetMapping("/checkout")
	public String showCheckout(Model model) {
		User user = gettingAuthentication();
		model.addAttribute("user",user);
		return "check_out";
	}
	
	@GetMapping("/orderSuccess")
	public String showOrderSuccess(Model model) {
		return "order_success";
	}
	
	
	
	
	
}
