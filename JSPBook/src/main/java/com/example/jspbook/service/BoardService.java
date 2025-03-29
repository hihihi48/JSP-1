package com.example.jspbook.service;

import java.util.List;

import com.example.jspbook.mapper.BoardMapper;
import com.example.jspbook.model.Board;

public class BoardService {

	private BoardMapper boardMapper;

	public void setBoardMapper(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	public List<Board> getAllBoards() {
		return boardMapper.getAllBoards();
	}
}
