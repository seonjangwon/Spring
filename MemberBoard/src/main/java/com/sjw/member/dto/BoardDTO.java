package com.sjw.member.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDTO {
	private long b_number;
	private String b_title;
	private String m_id; // 작성자는 회원id를 가져와볼까요
	private String b_contents;
	private long b_hits;
	private Timestamp b_date;
	
	private MultipartFile b_file;
	private String b_filename;
}
