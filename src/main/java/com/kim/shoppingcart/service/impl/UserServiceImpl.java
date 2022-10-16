package com.kim.shoppingcart.service.impl;

import java.util.Arrays;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kim.shoppingcart.dto.UserDto;
import com.kim.shoppingcart.model.*;
import com.kim.shoppingcart.repository.*;
import com.kim.shoppingcart.security.CustomUserDetailsService;
import com.kim.shoppingcart.service.UserService;

import lombok.*;


//@AllArgsConstructor(onConstructor=@__(@Autowired))
@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepo;
	
	private RoleRepository roleRepo;
	
	
	private PasswordEncoder passwordEncoder;
	
	//@Autowired (unecessary autowired)
	public UserServiceImpl(UserRepository userRepo,RoleRepository roleRepo, PasswordEncoder passwordEncoder) {
		//super();
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		
		user.setName(userDto.getFirstName()+" "+ userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setCity(userDto.getCity());
		user.setState(userDto.getState());
		user.setZipCode(userDto.getZipCode());
		
		// Encrypt the password using Spring Security
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//		
		Role role = roleRepo.findByName("ROLE_USER");
		
		if(role == null){
            role = checkRoleExist();
        }
		
        user.setRoles(Arrays.asList(role));
        userRepo.save(user);
		
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<User> users = userRepo.findAll();
		return users.stream()
				.map((user) -> mapToUserDto(user))
				.collect(Collectors.toList());
	}
	
	 private UserDto mapToUserDto(User user){
	        UserDto userDto = new UserDto();
	        String[] str = user.getName().split(" ");
	        userDto.setFirstName(str[0]);
	        userDto.setLastName(str[1]);
	        userDto.setEmail(user.getEmail());
	        userDto.setAddress(user.getAddress());
	        userDto.setCity(user.getCity());
	        userDto.setState(user.getState());
	        userDto.setZipCode(user.getZipCode());
	        return userDto;
	    }
	
	 private Role checkRoleExist(){
	        Role role = new Role();
	        role.setName("ROLE_USER");
	        return roleRepo.save(role);
	    }
	 
//	 public UserDetails getCurrentLoggedInUser(Authentication authentication) {
//		 if(authentication==null) return null;
//		 
//		 UserDetails user = null;
//		 Object principal = authentication.getPrincipal();
//		 
//		 if(principal instanceof CustomUserDetailsService) {
//			 user = ((CustomUserDetailsService) principal).getUser();
//			 
//		 }
//		 return user;
//	 }
	 
	

}
