package com.example.jspbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.example.jspbook.model.Board;
import com.example.jspbook.service.BoardService;

public class BoardController implements Controller {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 기본 요청은 목록 처리
		return list(req, res);
	}

	private ModelAndView list(HttpServletRequest req, HttpServletResponse res) {
		List<Board> boardList = boardService.getAllBoards();

		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("boardList", boardList);

		return mav;
	}
}
