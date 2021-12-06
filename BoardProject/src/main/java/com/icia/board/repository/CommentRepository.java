package com.icia.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.CommentDTO;

@Repository
public class CommentRepository {
	
	@Autowired
	private SqlSessionTemplate sql;

	public void save(CommentDTO c) {
		sql.insert("comment.save", c);
		
	}

	public List<CommentDTO> findAll(long b_number) {
		
		return sql.selectList("comment.findAll", b_number);
	}
	
	
}
