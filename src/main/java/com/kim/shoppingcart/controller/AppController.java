package com.kim.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/aboutus")
	public String showAboutUs() {
		return "aboutus";
	}
	
	@GetMapping("/cart4")
	public String showCart() {
		return "cart4";
	}
	
}
