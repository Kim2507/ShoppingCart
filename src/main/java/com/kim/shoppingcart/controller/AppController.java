package com.kim.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kim.shoppingcart.model.User;

@Controller
public class AppController {
	@Autowired
	CartController cartController;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/about_us")
	public String showAboutUs() {
		return "about_us";
	}
	
	@GetMapping("/cart4")
	public String showCart() {
		return null;
	}
	
	
}
