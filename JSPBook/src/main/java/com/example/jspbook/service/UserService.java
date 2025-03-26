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

	// ��ü ���� ��� ��ȸ
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}

	// Ư�� ���� ��ȸ
	public User getUserById(Long userId) {
		return userMapper.getUserById(userId);
	}

	// ���� ���
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	// ���� ������Ʈ
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	// ���� ����
	public void deleteUser(Long userId) {
		userMapper.deleteUser(userId);
	}
}
