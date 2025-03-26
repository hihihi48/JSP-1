package com.example.jspbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.jspbook.model.User;
import com.example.jspbook.service.UserService;
import com.example.jspbook.util.PasswordUtil;

public class UserController implements Controller {

	private UserService userService;

	// XML에서 setter로 주입
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String uri = req.getRequestURI();
		String ctx = req.getContextPath();
		String path = uri.substring(ctx.length());

		switch (path) {
		case "/users":
			return userList(req, res);
		case "/users/new":
			return showCreateForm(req, res);
		case "/users/create":
			return createUser(req, res);
		case "/users/edit":
			return showEditForm(req, res);
		case "/users/update":
			return updateUser(req, res);
		case "/users/delete":
			return deleteUser(req, res);
		default:
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	// 전체 유저 목록
	public ModelAndView userList(HttpServletRequest req, HttpServletResponse res) {
		List<User> users = userService.getAllUsers();

		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("users", users);

		return mav;
	}

	// 유저 등록 폼
	public ModelAndView showCreateForm(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView("user/form");
		mav.addObject("user", new User());
		mav.addObject("mode", "create");

		return mav;
	}

	// 등록 처리
	public ModelAndView createUser(HttpServletRequest req, HttpServletResponse res) {
		User user = new User();
		user.setUsername(req.getParameter("username"));
		user.setPassword(PasswordUtil.encode(req.getParameter("password")));
		user.setNickname(req.getParameter("nickname"));

		userService.insertUser(user);

		return new ModelAndView("redirect:/users");
	}

	// 수정 폼
	public ModelAndView showEditForm(HttpServletRequest req, HttpServletResponse res) {
		Long id = Long.parseLong(req.getParameter("id"));
		User user = userService.getUserById(id);

		ModelAndView mav = new ModelAndView("user/form");
		mav.addObject("user", user);
		mav.addObject("mode", "edit");

		return mav;
	}

	// 수정 처리
	public ModelAndView updateUser(HttpServletRequest req, HttpServletResponse res) {
		Long id = Long.parseLong(req.getParameter("id"));

		User user = new User();
		user.setUserId(id);
		user.setUsername(req.getParameter("username"));
		user.setPassword(PasswordUtil.encode(req.getParameter("password")));
		user.setNickname(req.getParameter("nickname"));

		userService.updateUser(user);

		return new ModelAndView("redirect:/users");
	}

	// 삭제
	public ModelAndView deleteUser(HttpServletRequest req, HttpServletResponse res) {
		Long id = Long.parseLong(req.getParameter("id"));

		userService.deleteUser(id);

		return new ModelAndView("redirect:/users");
	}
}
