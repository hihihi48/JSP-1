package com.example.jspbook.interceptor;

import com.example.jspbook.util.JwtUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// JWT 쿠키를 자동으로 확인해서 로그인 여부 판별하는 클래스
public class JwtInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		String token = null;

		// 쿠키에서 jwt 토큰 꺼내기
		if (req.getCookies() != null) {
			for (Cookie cookie : req.getCookies()) {
				if ("jwt".equals(cookie.getName())) {
					token = cookie.getValue();
					break;
				}
			}
		}

		// 토큰이 유효한 경우 패스
		if (token != null && JwtUtil.validateToken(token))
			return true;

		// 토큰이 없거나 유효하지 않으면 로그인 페이지로 이동
		res.sendRedirect(req.getContextPath() + "/login");

		return false;
	}
}
