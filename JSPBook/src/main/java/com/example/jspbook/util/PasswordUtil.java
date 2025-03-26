package com.example.jspbook.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	// ��ȣȭ
	public static String encode(String rawPassword) {
		return encoder.encode(rawPassword);
	}

	// �򹮰� �ؽ� ��
	public static boolean matches(String rawPassword, String encodedPassword) {
		return encoder.matches(rawPassword, encodedPassword);
	}
}
