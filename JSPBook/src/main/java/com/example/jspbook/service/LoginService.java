package com.example.jspbook.service;

import com.example.jspbook.mapper.UserMapper;
import com.example.jspbook.model.User;
import com.example.jspbook.util.PasswordUtil;

public class LoginService {

	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public User authenticate(String username, String password) {
		User user = userMapper.findByUsername(username);

		if (user != null && PasswordUtil.matches(password, user.getPassword())) {
			return user;
		}
		
		return null;
	}

}
