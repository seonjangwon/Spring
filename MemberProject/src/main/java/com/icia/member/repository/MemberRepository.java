package com.icia.member.repository;

import java.util.List;

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

	public MemberDTO signin(MemberDTO member) {
		return sql.selectOne("member.signin", member);
	}

	public List<MemberDTO> findAll() {
		List<MemberDTO> mList =sql.selectList("member.findAll");
		return mList;
	}

	public MemberDTO detail(long m_number) {
		MemberDTO m = sql.selectOne("member.detail", m_number);
		return m;
	}

	public void delete(long m_number) {
		sql.delete("member.delete",m_number);
		
	}

	public void update(MemberDTO m) {
		sql.update("member.update", m);
		
	}

	public String idDuplicate(String m_id) {
		String result = sql.selectOne("member.idDuplicate", m_id);
		return result;
	}

}
