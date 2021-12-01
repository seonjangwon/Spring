package com.icia.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private long b_number;
	private String b_writer;
	private String b_password;
	private String b_title;
	private String b_contents;
	private long b_hits;
	private Date b_date;
}
