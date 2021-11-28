package com.icia.member.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;

@Repository
public class MemberRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public void signup(MemberDTO member) {
		sql.insert("member.signup", member);
		
	}

	public Integer signin(MemberDTO member) {
		Integer result = sql.selectOne("member.signin", member);
		
		if(result==null) {
			result=0;
		}
		System.out.println(result);
		return result;
	}

}
