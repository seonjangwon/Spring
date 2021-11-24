package com.sjw.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjw.ex.dto.TraineeDTO;
import com.sjw.ex.repository.TraineeRepository;

@Service
public class TraineeService {

	@Autowired
	private TraineeRepository tr;
	
	public void insert(TraineeDTO trainee) {
		
		System.out.println("TraineeService.insert() 호출");
		System.out.println("객체값 : "+trainee);
		
		tr.insert(trainee);
	}

}
