package com.sjw.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/insert")
	public String insert() {

		return "insert";
	}

	@RequestMapping(value = "/insertparam", method = RequestMethod.POST)
	public String insertparam(@ModelAttribute TraineeDTO trainee) {

		// TraineeService에 있는 insert메서드 호출하면서 trainee 객체를 넘긴다면
		ts.insert(trainee);

		System.out.println(trainee);

		return "index";
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		
		List<TraineeDTO> tList = ts.findAll();
		
		model.addAttribute("tList", tList);
		
//		ts.findAll();

		return "findAll";
	}
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("t_number") long t_number) {
		System.out.println(t_number);
		
		// TraineeService.findById()
		// TraineeRepository.findById() (mapper호출시 sql.selectOne()사용)
		// trainee-mapper.findById 호출 (mapper에서 parameterType="long")
		
		// 호출하고 역순으로 리턴을 가져와서()리턴타입이 뭐가 돼야 할지 관건)
		// 결과 출력은 detail.jsp에서 객체값을 출력
		
		TraineeDTO t = ts.findById(t_number);
		
		model.addAttribute("t_number",t);
		
		return "detail";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("t_number") long t_number) {
		ts.deleteById(t_number);
		
		// 삭제처리후 단순히 findAll.jsp만 출력한 결과
//		return "findAll";
		
		// 삭제가 반영된 목록을 다시 요청해야하며,
		// 다시 요청하는 방식으 redirect
		// redirect를 할 때는 컨트롤러의 주소를 요청해야함
		return "redirect:/findAll";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updatepage(Model model, @RequestParam("t_number") long t_number) {
		
		TraineeDTO t = ts.findById(t_number);
		
		model.addAttribute("trainee",t);
		
		return "update";
	}
	
	@RequestMapping(value = "/updateparam", method = RequestMethod.POST)
	public String updateparam(@ModelAttribute TraineeDTO trainee) {
		
		ts.update(trainee);
		
		return "redirect:/findAll";
	}

}
