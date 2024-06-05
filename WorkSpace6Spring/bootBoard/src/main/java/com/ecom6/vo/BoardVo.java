package com.ecom6.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVo {
	private int start;		// 페이지 시작 레코드(tuple)
	private int end;		// 페이지 끝 레코드(tuple)
	private int rn;
	private int nbno;
	private int bno;
	private int bref;
	private int bstep;
	private int blevel;
	private int readcount;
	private String subject;
	private String content;
	private String writer;
	private String regdate;
	private String ip;
	private String passwd;
	private String items;
	private String text;
}
