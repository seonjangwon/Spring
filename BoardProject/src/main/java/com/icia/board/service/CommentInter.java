package com.icia.board.service;

import java.util.List;

import com.icia.board.dto.CommentDTO;

public interface CommentInter {
	
	public void save(CommentDTO c);
	
	public List<CommentDTO> findAll(long b_number);
	
}
