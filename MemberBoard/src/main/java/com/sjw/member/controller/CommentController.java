package com.sjw.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjw.member.dto.BoardDTO;
import com.sjw.member.dto.CommentDTO;
import com.sjw.member.service.BoardService;
import com.sjw.member.service.CommentService;

@Controller
@RequestMapping(value="/comment/")
public class CommentController {
	
	@Autowired
	private CommentService cs;
	@Autowired
	private BoardService bs;
	
	@RequestMapping(value="write", method = RequestMethod.POST)
	public @ResponseBody List<CommentDTO> write(@ModelAttribute CommentDTO c) {
		cs.write(c); // 작성용
		List<CommentDTO> cList = cs.findAll(c.getB_number());
		return cList;
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public @ResponseBody String delete(Model model,  @RequestParam("b_number") long b_number, @RequestParam("c_number") long c_number) {
		cs.delete(c_number);
		List<CommentDTO> cList = cs.findAll(c_number);
		BoardDTO bList = bs.detail(b_number);
		
		model.addAttribute("b", bList);
		model.addAttribute("cList", cList);
		
		return "/board/detail";
	}
}
