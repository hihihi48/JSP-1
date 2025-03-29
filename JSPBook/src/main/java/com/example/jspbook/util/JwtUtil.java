package com.example.jspbook.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

	// 비밀 키 (보안을 위해 환경변수 또는 설정파일 분리 권장)
	private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1시간, 유효 기간

	public static String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuer("jspbook-app").setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(SECRET_KEY).compact();
	}

	public static String getUsernameFromToken(String token) {
		return getClaims(token).getSubject();
	}

	public static boolean validateToken(String token) {
		try {
			getClaims(token);

			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}
	
	private static Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
