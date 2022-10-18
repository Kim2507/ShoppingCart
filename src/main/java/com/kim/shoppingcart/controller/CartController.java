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
	CartRepository cartRepo;
	@Autowired
	CartServiceImpl cartService;
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/shopping")
	public String showShopPage() {
		return "shopping";
	}
	
	
//	@GetMapping("/currentuserId")
//	@ResponseBody
//	public Long currentUserId() {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String userName = auth.getName();
//		User user = userService.findUserByEmail(userName);
//		return user.getId();
//		
//	}
	@PostMapping("/addedBT")
	public String addBTToCart(Model model) {

		// get the ID of the authenticated user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		User user = userService.findUserByEmail(userName);
		Long userId = user.getId();
		Cart cart = cartService.findByUserID((long)userId);
//
//		//Add product to cart
        cart.addProduct(productRepo.findById(1).get());
//		//cart.setProduct(productRepo.findById(1).get());
		model.addAttribute("cart",cart);
		cartRepo.save(cart);
		return "cart4";
	}
	
	@GetMapping("/checkout")
	public String showCheckout(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		User user = userService.findUserByEmail(userName);
		model.addAttribute("user",user);
		return "check_out";
	}
	
	@GetMapping("/orderSuccess")
	public String showOrderSuccess(Model model) {
		return "order_success";
	}
	
	
	
	
	
}
