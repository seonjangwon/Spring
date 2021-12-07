package com.sjw.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjw.member.dto.MemberDTO;

@Repository
public class MemberRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public void singup(MemberDTO m) {
		sql.insert("member.singup", m);
		
	}

	public String idch(String m_id) {
		
		return sql.selectOne("member.idch", m_id);
	}

	public MemberDTO signin(MemberDTO m) {
		
		return sql.selectOne("member.signin", m);
	}

	public void update(MemberDTO m) {
		sql.update("member.update", m);
		
	}

	public String pwch(String m_pw, String m_id) {
		MemberDTO m= new MemberDTO();
		m.setM_id(m_id);
		m.setM_password(m_pw);
		return sql.selectOne("member.pwch",m);
	}

	public List<MemberDTO> findAll() {
		// TODO Auto-generated method stub
		return sql.selectList("member.findAll");
	}

	public void delete(long m_number) {
		sql.delete("member.delete", m_number);
		
	}

}
