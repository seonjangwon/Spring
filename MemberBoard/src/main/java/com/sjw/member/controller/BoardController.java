package com.sjw.member.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sjw.member.dto.BoardDTO;
import com.sjw.member.dto.PageDTO;
import com.sjw.member.service.BoardService;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	@RequestMapping(value="write", method = RequestMethod.GET)
	public String writepage() {
		return "/board/write";
	}
	
	@RequestMapping(value="write", method = RequestMethod.POST)
	public String write(@ModelAttribute BoardDTO b) throws IllegalStateException, IOException {
		bs.write(b);
		
		return "index"; // 일단 인덱스로
	}
	
	@RequestMapping(value="findAll", method = RequestMethod.GET)
	public String findAll(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		PageDTO p = bs.paging(page);
		List<BoardDTO> bList = bs.pagingList(page);
		
		model.addAttribute("bList", bList);
		model.addAttribute("paging", p);
		
		return "/board/findAll";
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(@RequestParam("b_number") long b_number) {
		bs.delete(b_number);
		return "redirect/board/findAll";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("b_number") long b_number) {
		BoardDTO b = bs.detail(b_number);
		model.addAttribute("b", b);
		return "/board/detail";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String updatepage(Model model, @RequestParam("b_number") long b_number) {
		BoardDTO b = bs.detail(b_number);
		model.addAttribute("b", b);
		return "/board/update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardDTO b) {
		bs.update(b);
		
		return "/board/detail?b_number="+b.getB_number();
	}
	
}
