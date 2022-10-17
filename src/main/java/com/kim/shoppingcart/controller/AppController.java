package com.kim.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/aboutus")
	public String showAboutUs() {
		return "aboutus";
	}
	
	
	
}
