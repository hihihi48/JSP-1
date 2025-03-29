package com.example.jspbook.mapper;

import java.util.List;

import com.example.jspbook.model.User;

public interface UserMapper {
	List<User> getAllUsers();

	User getUserById(Long userId);

	User findByUsername(String username);

	void insertUser(User user);

	void updateUser(User user);

	void deleteUser(Long user);
}
