package com.icia.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	public HttpSession session;
	
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
	public String signin(Model model, @ModelAttribute MemberDTO member) {
		
		model.addAttribute("m_id", member.getM_id());
		
		MemberDTO result = ms.signin(member);
		String result1="";
		
		if (result!=null) {
			result1="main";
			session.setAttribute("loginById", member.getM_id());
			session.setAttribute("loginByNumber", result.getM_number());
		} else {
			result1="login";
		}
		
		return result1;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		session.invalidate(); // 세션에 담겨있는 데이터를 다 지운다
		return "index";
	}
	
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<MemberDTO> mList = ms.findAll();
		
		model.addAttribute("mList",mList);
		
		return "findAll";
		
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("m_number") long m_number) {
		
		MemberDTO m = ms.detail(m_number);
		
		model.addAttribute("mdto",m);
		
		return "detail";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("m_number") long m_number) {
		
		ms.delete(m_number);
		
		
		
		return "redirect:/findAll";
	}
}
