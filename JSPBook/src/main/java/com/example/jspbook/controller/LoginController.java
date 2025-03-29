package com.example.jspbook.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.jspbook.model.User;
import com.example.jspbook.service.LoginService;
import com.example.jspbook.service.UserService;
import com.example.jspbook.util.JwtUtil;
import com.example.jspbook.util.PasswordUtil;

public class LoginController implements Controller {

	private UserService userService;
	private LoginService loginService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// /login, /logout, /login/form 요청 구분
		String uri = req.getRequestURI();

		if (uri.endsWith("/login")) {
			return login(req, res);
		} else if (uri.endsWith("/logout")) {
			return logout(req, res);
		} else if (uri.endsWith("/login/form")) {
			return new ModelAndView("login/login");
		} else if (uri.endsWith("/register/form")) {
			return showRegisterForm();
		} else if (uri.endsWith("/register/submit")) {
			return register(req, res);
		}

		// 기본 fallback
		return new ModelAndView("redirect:/login/form");
	}

	private ModelAndView showRegisterForm() {
		ModelAndView mav = new ModelAndView("login/register");
		mav.addObject("user", new User());
		mav.addObject("mode", "create");
		return mav;
	}

	private ModelAndView register(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		String nickname = req.getParameter("nickname");

		// 비밀번호 확인
		if (!password.equals(confirmPassword)) {
			ModelAndView mav = new ModelAndView("login/register");
			mav.addObject("error", "비밀번호가 일치하지 않습니다.");
			return mav;
		}

		// 중복 사용자명 체크
		if (userService.findByUsername(username) != null) {
			ModelAndView mav = new ModelAndView("login/register");
			mav.addObject("error", "이미 존재하는 아이디입니다.");
			return mav;
		}

		// 사용자 등록
		User user = new User();
		user.setUsername(username);
		user.setPassword(PasswordUtil.encode(password));
		user.setNickname(nickname);

		userService.insertUser(user);

		return new ModelAndView("redirect:/login/form");
	}

	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// 사용자 인증
		User user = loginService.authenticate(username, password);

		if (user != null) {
			// JWT 토큰 생성
			String token = JwtUtil.generateToken(username);

			// 쿠키에 토큰 저장
			Cookie cookie = new Cookie("jwt", token);
			cookie.setHttpOnly(true);
			cookie.setPath("/"); // 전체 경로에서 유효하도록 설정
			cookie.setMaxAge(60 * 60); // 1시간

			res.addCookie(cookie);

			return new ModelAndView("redirect:/users"); // 추후 게시판 list로 변경
		} else {
			// 실패 시, 로그인 페이지로 이동
			ModelAndView mav = new ModelAndView("login/login");
			mav.addObject("error", "Invalid username or password");

			return mav;
		}
	}

	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) {
		// JWT 쿠키 삭제
		Cookie cookie = new Cookie("jwt", null);
		cookie.setMaxAge(0); // 만료 시간 0 -> 즉시 삭제
		cookie.setPath("/"); // 생성 시 path와 동일해야 함

		res.addCookie(cookie);

		return new ModelAndView("redirect:/login");
	}
}
