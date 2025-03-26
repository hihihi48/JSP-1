package com.example.jspbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jspbook.mapper.UserMapper;
import com.example.jspbook.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	// 전체 유저 목록 조회
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}

	// 특정 유저 조회
	public User getUserById(Long userId) {
		return userMapper.getUserById(userId);
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
