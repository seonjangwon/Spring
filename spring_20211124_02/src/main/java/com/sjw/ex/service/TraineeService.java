package com.sjw.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	
	

	public List<TraineeDTO> findAll() {
		
		List<TraineeDTO> tList = tr.findAll();
		
		// tList를 출력
		for(TraineeDTO e : tList) {
			System.out.println(e);
		}
		
		
		
		return tList;
	}



	public TraineeDTO findById(long t_number) {
		TraineeDTO t = tr.findById(t_number);
		return t;
	}



	public void deleteById(long t_number) {
		
		tr.deleteById(t_number);
		
	}



	public void update(TraineeDTO trainee) {
		tr.update(trainee);
		
	}





}
