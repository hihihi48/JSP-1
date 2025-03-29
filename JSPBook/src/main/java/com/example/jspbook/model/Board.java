package com.example.jspbook.model;

import java.util.Date;

public class Board {
	private Long boardId;

//	private Long categoryId;

	private String title;

	private String content;

	private String writer;

	private Date createdAt;

	private Date updatedAt;

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}

//	public Long getCategoryId() {
//		return categoryId;
//	}
	
//	public void setCategoryId(Long categoryId) {
//		this.categoryId = categoryId;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
