package com.sjw.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjw.member.dto.CommentDTO;

@Repository
public class CommentRepository {
	@Autowired
	private SqlSessionTemplate sql;

	public void write(CommentDTO c) {
		sql.insert("comment.write", c);
		
	}

	public List<CommentDTO> findAll(long b_number) {
		return sql.selectList("comment.findAll", b_number);
	}

	public void delete(long c_number) {
		sql.delete("comment.delete", c_number);
		
	}
}
