package com.sjw.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "index";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginparam", method = RequestMethod.POST)
	public String loginparam(Model model, @RequestParam("idparam") String idparam, @RequestParam("pwparam") String pwparam) {
		System.out.println("id : " + idparam + "  pw : " + pwparam);
		
		//id를 idValue에 담아서 welcom.jsp로 가져가기
		model.addAttribute("idValue",idparam);
		//pw를 pwValue에 담고 welcome.jsp에서 출력
		model.addAttribute("pwValue",pwparam);
		
		// val 변수를 hello에 담아서 welcom.jsp에서 출력
		String val = "이제 곹 끝나요";
		model.addAttribute("bye",val);
		
		
		return "welcom";
	}
	
	
	
	
	
	
	
	
	
	
}
