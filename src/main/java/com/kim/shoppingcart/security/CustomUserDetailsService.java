package com.kim.shoppingcart.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.kim.shoppingcart.model.User;
import com.kim.shoppingcart.repository.UserRepository;

import lombok.*;

@NoArgsConstructor
@Data
@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private UserRepository userRepo;
	private UserDetails user;

	
	@Autowired
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepo = userRepository;
	}
	

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(usernameOrEmail);
		
		if(user!=null) {
			return new org.springframework.security.core.userdetails.User(user.getEmail()
                    ,user.getPassword(),
                    user.getRoles().stream()
                    .map((role) -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList()));
			
		}else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
	}
	
	public UserDetails getCurrentLoggedInUser(Authentication authentication) {
		 if(authentication==null) return null;
		 
		 UserDetails user = null;
		 Object principal = authentication.getPrincipal();
		 
		 if(principal instanceof CustomUserDetailsService) {
			 user = ((CustomUserDetailsService) principal).getUser();
			 
		 }
		 
		 return user;
	 }
	

}

