package com.example.jspbook.controller;

import com.example.jspbook.service.UserService;

public class UserController {

	private UserService userService;

	// XML에서 setter로 주입
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
