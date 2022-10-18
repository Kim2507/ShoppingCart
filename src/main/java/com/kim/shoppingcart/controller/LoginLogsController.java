package com.kim.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kim.shoppingcart.model.User;
import com.kim.shoppingcart.service.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginLogsController {
	@Autowired 
	UserServiceImpl userService;
	@GetMapping("/auditlogs")
	public String showLoggerData() {
//		private Logger log = LoggerFactory.getILoggerFactory(LewisLoginController.class);
		log.trace("This is a trace message");
		log.info("slf4j working as an abstract to allow the Logger Framework for an info message");
		log.debug("This is a debugging message");
		log.error("This is an error message");
		log.warn("This is a warning message");

		return "Each level log displays on the console output";

	}
	
	

}
