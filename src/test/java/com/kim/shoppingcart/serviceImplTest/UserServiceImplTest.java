package com.kim.shoppingcart.serviceImplTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kim.shoppingcart.dto.UserDto;
import com.kim.shoppingcart.model.Role;
import com.kim.shoppingcart.model.User;
import com.kim.shoppingcart.repository.RoleRepository;
import com.kim.shoppingcart.repository.UserRepository;
import com.kim.shoppingcart.service.impl.UserServiceImpl;

@SpringBootTest
public class UserServiceImplTest {
	@Autowired 
	UserServiceImpl userService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;
	

	
//	@Test // succeed
//	public void testFindUserByEmail() {
//		User expected = new User();
//		expected.setEmail("kim@gmail.com");
//		User actual = userService.findUserByEmail("kim@gmail.com");
//		assertEquals(expected.getEmail(),actual.getEmail());
//	}
//	
//	@Test // succeed
//	public void testFindAllUsers() {
//		List<User> users = userRepo.findAll();
//	}
	
	@ParameterizedTest
	@ValueSource(strings ={"Malden","Melrose","Saugus"})
	@Test 
	public void testFindUserByCity(String str) {
		assertNotNull(userService.findUserByCity(str));
	}
	
	
	@Test
	public void testFindByState() {
		assertNotNull(userService.findUserByState("MA"));
	}
	
	@Test
	public void testFindByName() {
		assertNotNull(userService.findUserByName("Tr"));
	}

}
