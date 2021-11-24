package com.sjw.work;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "index";
	}
	@RequestMapping(value="/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="/join2")
	public String join2() {
		return "join2";
	}
	
	
	@RequestMapping(value="/joinparam", method=RequestMethod.POST)
	public String memberjoin(Model model, @RequestParam("id") String id,@RequestParam("pw") String pw,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("gender") String gender) {
		
		
		MemberDTO m = new MemberDTO();
		m.setId(id);
		m.setPw(pw);
		m.setName(name);
		m.setEmail(email);
		m.setGender(gender);
		
		model.addAttribute("MemberDTO", m);
		
		return "memberjoin";
	}
	
	
	// 주의
	// ModelAttribute로 DTO에 담을 때
	// jsp에서 사용한 name값과 DTO 필드값이 똑같아야함
	@RequestMapping(value="/joinparam2", method=RequestMethod.POST)
	public String memberjoin2(Model m, @ModelAttribute MemberDTO member) {
		
		System.out.println("memberjoin2 : "+ member);
		
		m.addAttribute("MemberDTO", member);
		
		return "memberjoin";
	}
	
	
	
	
	
	
	
	
	
	
	
}
