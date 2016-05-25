package com.qa.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.qa.ims.controller.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public boolean authenticate(String username, String password) {
		return userService.valid(username, password);
	}

}
