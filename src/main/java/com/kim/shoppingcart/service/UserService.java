package com.kim.shoppingcart.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.shoppingcart.dto.UserDto;
import com.kim.shoppingcart.model.User;



public interface UserService {
	void saveUser(UserDto userDto);
	
	void deleteUser(Long id);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
    
    List<User> findUserByCity(String city);
    
    List<User> findUserByState(String state);
    
    List<User> findUserByName(String name);

}