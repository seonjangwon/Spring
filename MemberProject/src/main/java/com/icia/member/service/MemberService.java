package com.icia.member.service;

import java.util.List;

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

	public MemberDTO signin(MemberDTO member) {

		MemberDTO result = mr.signin(member);
		
		return result;
	}

	public List<MemberDTO> findAll() {
		
		return mr.findAll();
	}

	public MemberDTO detail(long m_number) {
		MemberDTO m = mr.detail(m_number);
		return m;
	}

	public void delete(long m_number) {
		mr.delete(m_number);
		
	}

	public void update(MemberDTO m) {
		mr.update(m);
		
	}

	public String idDuplicate(String m_id) {
		String result = mr.idDuplicate(m_id);
		if(result==null)
			return "ok";
		else
		return "no";
	}

}
