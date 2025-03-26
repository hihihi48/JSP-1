package com.example.jspbook.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	// 암호화
	public static String encode(String rawPassword) {
		return encoder.encode(rawPassword);
	}

	// 평문과 해시 비교
	public static boolean matches(String rawPassword, String encodedPassword) {
		return encoder.matches(rawPassword, encodedPassword);
	}
}
