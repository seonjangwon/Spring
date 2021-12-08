package com.sjw.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjw.member.dto.BoardDTO;
import com.sjw.member.dto.MemberDTO;
import com.sjw.member.service.BoardService;
import com.sjw.member.service.MemberService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private MemberService ms;
	@Autowired
	private BoardService bs;

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String singuppage() {

		return "/member/signup";
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String singup(@ModelAttribute MemberDTO m) throws IllegalStateException, IOException {
		ms.singup(m);
		return "index";
	}

	@RequestMapping(value = "idch", method = RequestMethod.POST)
	public @ResponseBody String idch(@RequestParam("m_id") String m_id) {
		String result = ms.idch(m_id);

		if (result == null) {
			return "no";
		} else {
			return "ok";
		}
	}

	@RequestMapping(value = "signin", method = RequestMethod.GET)
	public String singinpage() {

		return "/member/signin";
	}

	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public String singin(@ModelAttribute MemberDTO m) {

		MemberDTO result = ms.signin(m);
		if (result == null) {
			return "/member/signin";
		} else {
			session.setAttribute("loginDTO", result);
			return "index";
		}
	}

	@RequestMapping(value = "signout", method = RequestMethod.GET)
	public String singout() {

		session.invalidate();

		return "index";
	}
	
	// 마이페이지용
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public String mypage() {

		return "/member/mypage";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updatepage() {

		return "/member/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute MemberDTO m) throws IllegalStateException, IOException {

		ms.update(m);

		return "/member/mypage";
	}

	@RequestMapping(value = "pwch", method = RequestMethod.POST)
	public @ResponseBody String pwch(@RequestParam("m_pw") String m_pw, @RequestParam("m_id") String m_id) {

		String result = ms.pwch(m_pw, m_id);

		if (result == null) {
			return "no";
		} else {
			return "ok";
		}
	}

	
	@RequestMapping(value = "myboard", method = RequestMethod.GET)
	public String myboard(Model model, @RequestParam("m_id") String m_id) {
		List<BoardDTO> bList = bs.findBym_id(m_id);
		model.addAttribute("bList", bList);
		return "/member/myboard";
	}

	// 관리자용

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String admin() {

		return "/member/admin";
	}

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<MemberDTO> mList = ms.findAll();

		model.addAttribute("mList", mList);

		return "/member/findAll";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("m_number") long m_number) {

		ms.delete(m_number);

		return "redirect:/member/findAll";
	}

}
