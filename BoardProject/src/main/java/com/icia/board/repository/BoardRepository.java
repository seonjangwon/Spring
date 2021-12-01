package com.icia.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;

@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public void write(BoardDTO b) {
		System.out.println("r"+b);
		sql.insert("board.write", b);
		
	}

	public List<BoardDTO> findAll() {
		List<BoardDTO> bList = sql.selectList("board.findAll");
		return bList;
	}

	public BoardDTO detail(long b_number) {
		BoardDTO b = sql.selectOne("board.detail", b_number);
		return b;
	}

	public void delete(long b_number) {
		sql.delete("board.delete",b_number);
		
	}

	public void hits(long b_number) {
		sql.update("board.hits", b_number);
		
	}

	public void update(BoardDTO b) {
		sql.update("board.update", b);
		
	}

	public List<BoardDTO> search(String b_title) {
		List<BoardDTO> tList = sql.selectList("board.search", b_title);
		return tList;
	}

}