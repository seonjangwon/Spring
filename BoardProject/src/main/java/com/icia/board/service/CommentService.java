package com.icia.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dto.CommentDTO;
import com.icia.board.repository.CommentRepository;

@Service
public class CommentService implements CommentInter {
	
	@Autowired
	private CommentRepository cr;
	
	@Override
	public void save(CommentDTO c) {
		cr.save(c);
		
	}
	
	@Override
	public List<CommentDTO> findAll(long b_number) {

		return cr.findAll(b_number);
	}
	
}
