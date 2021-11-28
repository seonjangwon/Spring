package com.sjw.ex.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjw.ex.dto.TraineeDTO;

@Repository
public class TraineeRepository {
	
	@Autowired
	public SqlSessionTemplate sql;
	
	public void insert(TraineeDTO trainee) {
		sql.insert("Trainee.insertTrainee", trainee);
		
	}

	public List<TraineeDTO> findAll() {
		
		return sql.selectList("Trainee.findAll");
	}

	public TraineeDTO findById(long t_number) {
	
		return sql.selectOne("Trainee.findById", t_number);
	}

	public void deleteById(long t_number) {
		sql.delete("Trainee.deleteById", t_number);
		
	}

	public void update(TraineeDTO trainee) {
		sql.update("Trainee.update", trainee);
		
	}



}
