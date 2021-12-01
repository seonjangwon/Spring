package com.icia.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository br;
	
	public void write(BoardDTO b) {
		System.out.println("s"+b);
		br.write(b);
		
	}

	public List<BoardDTO> findAll() {
		List<BoardDTO> bList = br.findAll();
		return bList;
	}

	public BoardDTO detail(long b_number) {
		BoardDTO b = br.detail(b_number);
		return b;
	}

	public void delete(long b_number) {
		br.delete(b_number);
		
	}

	public void hits(long b_number) {
		br.hits(b_number);
		
	}

	public void update(BoardDTO b) {
		br.update(b);
		
	}

	public List<BoardDTO> search(String b_title) {
		List<BoardDTO> tList = br.search(b_title);
		return tList;
	}

}
