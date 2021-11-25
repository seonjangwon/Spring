package com.seon.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

// 리턴타입 : String
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		
		// 기본 주소(/) 요청에 대해 home.jsp를 출력해줌.
		// 컨트롤러 메서드에서 String 리턴은 해당 String값 .jsp를 출력하도록 처리됨
		// ViewResolver가 해줌.
		return "home";
	}
	
	
	// hello 주소를 받아줄 메서드 선언
	@RequestMapping(value="/hello")
	public String hello() {
		System.out.println("hello 메서드 호출 되었습니다.");
		// hi.jsp 출력
		return "hi";
	}
	
	
	@RequestMapping(value="/intro")
	public String intro() {
		
		return "intro";
	}
	
	@RequestMapping(value="/input")
	public String input() {
		
		return "input";
	}
	
	
	// 화면에서 전당한 파라미터 받기
	@RequestMapping(value="/inputparam", method=RequestMethod.POST) // 보내는 방식과 받는 방식이 일치해야한다 아니면 405오류
	public String inputparam(@RequestParam("param1") String param1,@RequestParam("param2") String param2) {
		System.out.println("inputparam 메서드");
		System.out.println("param1 : "+param1);
		System.out.println("param2 : "+param2);
		return "home";
	}
	
}
