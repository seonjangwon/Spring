package com.icia.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository mr;
	
	public void signup(MemberDTO member) {
		mr.signup(member);
		
	}

	public int signin(MemberDTO member) {

		Integer result = mr.signin(member);
		
		return result;
	}

}
