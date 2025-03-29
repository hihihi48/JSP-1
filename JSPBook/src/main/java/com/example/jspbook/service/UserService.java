package com.example.jspbook.service;

import java.util.List;

import com.example.jspbook.mapper.UserMapper;
import com.example.jspbook.model.User;

public class UserService {

	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	// 전체 유저 목록 조회
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}

	// 특정 유저 조회
	public User getUserById(Long userId) {
		return userMapper.getUserById(userId);
	}

	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}

	// 유저 등록
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	// 유저 업데이트
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	// 유저 삭제
	public void deleteUser(Long userId) {
		userMapper.deleteUser(userId);
	}
}
