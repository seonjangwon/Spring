package com.sjw.member.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjw.member.dto.BoardDTO;

@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public void write(BoardDTO b) {
		sql.insert("board.write", b);
		
	}

	public int count() {
		
		return sql.selectOne("board.count");
	}

	public List<BoardDTO> pagingList(Map<String, Integer> pagingMap) {
		
		return sql.selectList("board.paging", pagingMap);
	}

	public void delete(long b_number) {
		sql.delete("board.delete", b_number);
		
	}

	public BoardDTO detail(long b_number) {
		
		return sql.selectOne("board.detail", b_number);
	}

	public void update(BoardDTO b) {
		sql.update("board.update", b);
		
	}

	public List<BoardDTO> search(Map<String, String> search) {
		
		return sql.selectList("board.search", search);
	}

	public void hits(long b_number) {
		sql.update("board.hits", b_number);
		
	}

	public List<BoardDTO> findBym_id(String m_id) {
		
		return sql.selectList("board.findBym_id", m_id);
	}

}
