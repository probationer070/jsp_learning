package com.ecom6.common.vo;

public class PageVO {
	private int pgCnt;		// 총 페이지
	private int BlockCnt;	// 총 페이지 블록 수
	private int curPg = 1;	// 현재 페이지 수
	private int curBlock = 1;	// 현재 페이지 블록 수
	private int startPage = 1;	// 현재 블록의 시작 페이지
	private int endPage = 1;	// 현재 블록의 끝 페이지
}
