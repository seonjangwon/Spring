package com.sjw.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjw.member.dto.CommentDTO;
import com.sjw.member.service.CommentService;

@Controller
@RequestMapping(value="/comment/")
public class CommentController {
	
	@Autowired
	private CommentService cs;
	
	@RequestMapping(value="write", method = RequestMethod.POST)
	public @ResponseBody List<CommentDTO> write(@ModelAttribute CommentDTO c) {
		cs.write(c); // 작성용
		List<CommentDTO> cList = cs.findAll(c.getB_number());
		return cList;
	}
	
	@RequestMapping(value="delete", method = RequestMethod.POST)
	public @ResponseBody List<CommentDTO> delete(@ModelAttribute CommentDTO c) {
		cs.delete(c.getC_number());
		List<CommentDTO> cList = cs.findAll(c.getB_number());
		return cList;
	}
}
