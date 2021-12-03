package com.icia.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.service.BoardService;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {

		return "board/insert";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(@ModelAttribute BoardDTO b) {
		System.out.println("c"+b);
		bs.write(b);
		
		return "redirect:/board/findAll"; // 일단 인덱스로 해두고 파인드올으로 바꾸자
	}
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<BoardDTO> bList = bs.findAll();
		
		model.addAttribute("bList",bList);
		
		return "board/findAll";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("b_number") long b_number, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		
		bs.hits(b_number);
		
		BoardDTO b = bs.detail(b_number); // 조회
		System.out.println(b);
		model.addAttribute("b",b);
		model.addAttribute("page", page);
		return "board/detail";
	}
	
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("b_number") long b_number) {
		
		bs.delete(b_number);
		
		return "redirect:/board/findAll"; 
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updatepage(Model model, @RequestParam("b_number") long b_number, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		
		BoardDTO b =bs.detail(b_number);
		
		model.addAttribute("b",b);
		model.addAttribute("page", page);
		return "board/update"; 
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Model model,@ModelAttribute BoardDTO b,@RequestParam(value="page", required=false, defaultValue="1")int page) {
		bs.update(b);
		model.addAttribute("page", page);
		return "redirect:/board/detail?page="+page+"&b_number="+b.getB_number();
	}
	
	

	
	
	@RequestMapping(value="paging", method=RequestMethod.GET)
	// value는 파라미터이름 , required는 필수 여부
	public String paging(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		PageDTO paging = bs.paging(page);
		List<BoardDTO> boardList = bs.pagingList(page);
		model.addAttribute("bList", boardList);
		model.addAttribute("paging", paging);
		return "board/findAll";
	}
	
	@RequestMapping(value="search", method = RequestMethod.GET)
	public String search(@RequestParam("searchtype") String searchtype, @RequestParam("keyword") String keyword, Model model) {
		List<BoardDTO> bList = bs.search(searchtype,keyword);
		model.addAttribute("bList", bList);
		return "board/findAll";
	}
	
	
}
