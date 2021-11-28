package com.icia.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "index";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {

		return "insert";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String singup(@ModelAttribute MemberDTO member) {

		ms.signup(member);

		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(@ModelAttribute MemberDTO member) {
		
		Integer result = ms.signin(member);
		String result1="";
		
		if (result!=0) {
			result1="index";
		} else {
			result1="login";
		}
		
		return result1;
	}
	
	
	

}
