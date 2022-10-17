package com.kim.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/about_us")
	public String showAboutUs() {
		return "about_us";
	}
	
	
	
}
