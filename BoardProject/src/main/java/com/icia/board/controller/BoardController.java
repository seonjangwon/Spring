package com.icia.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.board.dto.BoardDTO;
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
	public String detail(Model model, @RequestParam("b_number") long b_number) {
		
		bs.hits(b_number);
		
		BoardDTO b = bs.detail(b_number); // 조회
		System.out.println(b);
		model.addAttribute("b",b);
		
		return "board/detail";
	}
	
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("b_number") long b_number) {
		
		bs.delete(b_number);
		
		return "redirect:/board/findAll"; 
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updatepage(Model model, @RequestParam("b_number") long b_number) {
		
		BoardDTO b =bs.detail(b_number);
		
		model.addAttribute("b",b);
		
		return "board/update"; 
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardDTO b) {
		bs.update(b);
		return "redirect:/board/findAll";
	}
	
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(Model model, @RequestParam("b_title") String b) {
		
		List<BoardDTO> tList = bs.search(b);
		
		model.addAttribute("bList", tList);
		
		return "board/search";
	}
	
	
	@RequestMapping(value = "paging", method = RequestMethod.GET)
	public String paging() {
		
		return "board/paging";
	}
	
	
	
	
}
