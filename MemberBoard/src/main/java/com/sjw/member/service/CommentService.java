package com.sjw.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjw.member.dto.CommentDTO;
import com.sjw.member.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository cr;

	public void write(CommentDTO c) {
		cr.write(c);
		
	}

	public List<CommentDTO> findAll(long b_number) {
		return cr.findAll(b_number);
	}

	public void delete(long c_number) {
		cr.delete(c_number);
		
	}
}
