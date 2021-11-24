package com.sjw.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sjw.ex.dto.TraineeDTO;
import com.sjw.ex.service.TraineeService;

@Controller
public class HomeController {

	// 스프링이 관리하는 객체를 ㅇ사용하기
	// 의존성 주입(DI, Dependency Injection)
	@Autowired
	private TraineeService ts;
//	TraineeService ts = new TraineeService();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		return "index";
	}
	
	@RequestMapping(value="/insert")
	public String insert() {
		
		return "insert";
	}
	
	@RequestMapping(value="/insertparam", method=RequestMethod.POST)
	public String insertparam(@ModelAttribute TraineeDTO trainee) {
		
		// TraineeService에 있는 insert메서드 호출하면서 trainee 객체를 넘긴다면
		ts.insert(trainee);
		
		System.out.println(trainee);
		
		return "success";
	}
	
}
