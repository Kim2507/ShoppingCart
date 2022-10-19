package com.kim.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kim.shoppingcart.service.impl.UserServiceImpl;
import com.kim.shoppingcart.dto.UserDto;


@RestController
public class UserRestController {
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/users")
	public List<UserDto> addUser() {
		
		return userService.findAllUsers();
	}
	
	@DeleteMapping("/users/{id}")
	void deleteProduct(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
}
