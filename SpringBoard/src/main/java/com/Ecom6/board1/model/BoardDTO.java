package com.Ecom6.board1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
	private int start;		// ������ ���� ���ڵ�(tuple)
	private int end;		// ������ �� ���ڵ�(tuple)
	
	private int rn;
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
}
