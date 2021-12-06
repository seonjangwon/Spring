package com.icia.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.board.dto.CommentDTO;
import com.icia.board.service.CommentInter;

@Controller
@RequestMapping(value="/comment/*")
public class CommentController {
	
	@Autowired
	private CommentInter cs;
	
	@RequestMapping(value="save", method = RequestMethod.POST)
	public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO c) {
		System.out.println("qkdjlkfajfla"+c);
		cs.save(c);
		List<CommentDTO> cList = cs.findAll(c.getB_number());
		
		for(CommentDTO co: cList ) {
			System.out.println(co);
		}
		return cList;
	}
}
