package com.icia.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
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



	private static final int PAGE_LIMIT = 3; // 한페이지에 보여질 글 개수 
	private static final int BLOCK_LIMIT = 3; // 한화면에 보여질 페이지 개수


	public List<BoardDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		// 1페이지 limit 0,3 / 2페이지 3,3 / 3페이지 6,3
		int pagingStart = (page-1) * PAGE_LIMIT;
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
//		List<BoardDTO> pagingList = br.pagingList(pagingStart);
		List<BoardDTO> pagingList = br.pagingList1(pagingParam);
		for(BoardDTO b: pagingList) {
			System.out.println(b.toString());
		}
		return pagingList;
	}

	// 필요한 총 페이지 갯수 계산
	// 현재 사용자가 요청한 페이지가 2페이지라면 화면에는 1,2,3을 보여주고
	// 요청 페이지가 6페이지라면 화면에 4,5,6을 보여준다
	// 요청페이지가 7페이지라면 7을 보여준다
	public PageDTO paging(int page) {
		int boardCount = br.boardCount(); // 필요한 총 글 갯수
		// 전체페이지 계산
		int maxPage = (int)(Math.ceil((double)boardCount / PAGE_LIMIT)); // ceil() : 소수점이 붙으면 값을 올려준다
		// 2페이지를 요청했을 때 1페이지, 4페이지를 요청했을 때 4페이지, 8페이지를 요청했을 때 7페이지
		// 1, 2, 3 >> 1
		// 4, 5, 6 >> 4
		// 7, 8, 9 >> 7
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1; // BLOCK_LIMIT은 페이지에 보이는 페이지수 
		int endPage = startPage + BLOCK_LIMIT - 1;
		if(endPage > maxPage)
			endPage = maxPage; 
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		System.out.println("paging.toString(): "+ paging.toString());
		
		return paging;
	}

	public List<BoardDTO> search(String searchtype, String keyword) {
		Map<String, String> searchParam = new HashMap<String, String>();
		searchParam.put("type", searchtype);
		searchParam.put("word", keyword);
		return br.search(searchParam);
	}

}
