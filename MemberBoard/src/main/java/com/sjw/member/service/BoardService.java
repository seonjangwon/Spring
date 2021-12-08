package com.sjw.member.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sjw.member.dto.BoardDTO;
import com.sjw.member.dto.PageDTO;
import com.sjw.member.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository br;
	
	public void write(BoardDTO b) throws IllegalStateException, IOException {
		// dto에 담긴 파일을 가져옴
				MultipartFile b_file = b.getB_file();
				// 파일 이름을 가져옴(파일이름을 DB에 저장하기 위해)
				String b_filename = b_file.getOriginalFilename();
				// 파일명 중복을 피하기 위해 파일이름앞에 현재 시간값을 붙임.
				b_filename = System.currentTimeMillis() + "-" + b_filename;
				System.out.println("b_filename: " + b_filename);
				// 파일 저장하기
				String savePath = "D:\\development\\source\\Spring\\MemberBoard\\src\\main\\webapp\\resources\\upload\\"
						+ b_filename;
				// bfile이 비어있지 않다면(즉 파일이 있으면) savePath에 저장을 하겠다.
				if (!b_file.isEmpty()) {
					b_file.transferTo(new File(savePath));
				}
				// 여기까지의 내용은 파일을 저장하는 과정

				// DB에 저장하기 위해 DTO에 파일이름을 담는다
				b.setB_filename(b_filename);

				// DB의 board에 파일이름을 저장할 b_filename이라는 컬럼 추가(타입은 varchar(100))
		br.write(b);
		
	}
	
	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 5;
	
	public PageDTO paging(int page) {
		int boardCount = br.count();
		int maxPage = (int)(Math.ceil((double)boardCount / PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)boardCount/BLOCK_LIMIT)))-1)*BLOCK_LIMIT+1;
		int endPage = startPage+BLOCK_LIMIT-1;
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		PageDTO p = new PageDTO();
		p.setPage(page);
		p.setStartPage(startPage);
		p.setMaxPage(maxPage);
		p.setEndPage(endPage);
		return p;
	}

	public List<BoardDTO> pagingList(int page) {
		int pagingStart = (page-1) * PAGE_LIMIT;
		Map<String, Integer> pagingMap =new HashMap<String, Integer>();
		pagingMap.put("start", pagingStart);
		pagingMap.put("limit", PAGE_LIMIT);
		List<BoardDTO> bList = br.pagingList(pagingMap);
		return bList;
	}

	public void delete(long b_number) {
		br.delete(b_number);
		
	}

	public BoardDTO detail(long b_number) {
		
		return br.detail(b_number);
	}

	public void update(BoardDTO b) {
		br.update(b);
		
	}

	public List<BoardDTO> search(String searchtype, String keyword) {
		Map<String, String> search = new HashMap<String, String>();
		search.put("keyword", keyword);
		search.put("searchtype", searchtype);
		return br.search(search);
	}

	public void hits(long b_number) {
		br.hits(b_number);
		
	}

	public List<BoardDTO> findBym_id(String m_id) {
		
		return br.findBym_id(m_id);
	}

}
