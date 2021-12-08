package com.sjw.member.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sjw.member.dto.MemberDTO;
import com.sjw.member.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository mr;

	public void singup(MemberDTO m) throws IllegalStateException, IOException {
		// dto에 담긴 파일을 가져옴
		MultipartFile m_file = m.getM_file();
		// 파일 이름을 가져옴(파일이름을 DB에 저장하기 위해)
		String m_filename = m_file.getOriginalFilename();
		// 파일명 중복을 피하기 위해 파일이름앞에 현재 시간값을 붙임.
		m_filename = System.currentTimeMillis() + "-" + m_filename;
		System.out.println("b_filename: " + m_filename);
		// 파일 저장하기
		String savePath = "D:\\development\\source\\Spring\\MemberBoard\\src\\main\\webapp\\resources\\upload\\"
				+ m_filename;
		// bfile이 비어있지 않다면(즉 파일이 있으면) savePath에 저장을 하겠다.
		if (!m_file.isEmpty()) {
			m_file.transferTo(new File(savePath));
		}
		// 여기까지의 내용은 파일을 저장하는 과정

		// DB에 저장하기 위해 DTO에 파일이름을 담는다
		m.setM_filename(m_filename);

		// DB의 board에 파일이름을 저장할 b_filename이라는 컬럼 추가(타입은 varchar(100))
		mr.singup(m);
	}

	public String idch(String m_id) {

		return mr.idch(m_id);
	}

	public MemberDTO signin(MemberDTO m) {

		return mr.signin(m);
	}

	public void update(MemberDTO m) throws IllegalStateException, IOException {
		// dto에 담긴 파일을 가져옴
		MultipartFile m_file = m.getM_file();
		// 파일 이름을 가져옴(파일이름을 DB에 저장하기 위해)
		String m_filename = m_file.getOriginalFilename();
		// 파일명 중복을 피하기 위해 파일이름앞에 현재 시간값을 붙임.
		m_filename = System.currentTimeMillis() + "-" + m_filename;
		System.out.println("b_filename: " + m_filename);
		// 파일 저장하기
		String savePath = "D:\\development_sjw\\source\\Spring\\MemberBoard\\src\\main\\webapp\\resources\\upload\\"
				+ m_filename;
		// bfile이 비어있지 않다면(즉 파일이 있으면) savePath에 저장을 하겠다.
		if (!m_file.isEmpty()) {
			m_file.transferTo(new File(savePath));
		}
		// 여기까지의 내용은 파일을 저장하는 과정

		// DB에 저장하기 위해 DTO에 파일이름을 담는다
		m.setM_filename(m_filename);

		// DB의 board에 파일이름을 저장할 b_filename이라는 컬럼 추가(타입은 varchar(100))
		mr.update(m);

	}

	public String pwch(String m_pw, String m_id) {

		return mr.pwch(m_pw, m_id);
	}

	public List<MemberDTO> findAll() {
		// TODO Auto-generated method stub
		return mr.findAll();
	}

	public void delete(long m_number) {
		mr.delete(m_number);
		
	}

}
