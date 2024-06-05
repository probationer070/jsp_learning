package com.ecom6.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom6.dao.BoardDao;
import com.ecom6.vo.BoardVo;
import com.ecom6.vo.PageVo;
import com.ecom6.vo.Pageinfo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public Map<String, Object> getBoardList(BoardVo bvo, PageVo pvo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// Total
		int totArticle = boardDao.TotArticle(bvo);
		resultMap.put("totArticle", totArticle);
		
		// 페이지 계산
		// 1. 전체 페이지 수
		int pgcnt = totArticle%Pageinfo.ROW_OF_PAGE==0 ?
			     totArticle/Pageinfo.ROW_OF_PAGE: 
				 totArticle/Pageinfo.ROW_OF_PAGE+1;
		pvo.setPgCnt(pgcnt);
		// 2. 현재 페이지 수 pvo.getCurPg()를 통해서 시작 레코드와 끝 레코드
		int start = ((pvo.getCurPg()-1) * Pageinfo.ROW_OF_PAGE)+1;
		int end = (pvo.getCurPg() * Pageinfo.ROW_OF_PAGE) > totArticle?		 
	       		   totArticle: (pvo.getCurPg() * Pageinfo.ROW_OF_PAGE);
		
		bvo.setStart(start);
		bvo.setEnd(end);
		
		// 총 블록 수 계산
			// 전체 블록 수
		int blcnt = pvo.getPgCnt() % Pageinfo.PAGE_OF_BLOCK == 0 ?
					pvo.getPgCnt() / Pageinfo.PAGE_OF_BLOCK :
					pvo.getPgCnt() / Pageinfo.PAGE_OF_BLOCK + 1;
		
			// 현재 페이지 블록, 시작페이지와 끝페이지를 계산
		int startPg = (pvo.getCurBlock()-1) * Pageinfo.PAGE_OF_BLOCK + 1;
		int endPg = pvo.getCurBlock() * Pageinfo.PAGE_OF_BLOCK > pvo.getPgCnt() ?
					pvo.getPgCnt() : pvo.getCurBlock() * Pageinfo.PAGE_OF_BLOCK;
		
		pvo.setBlockCnt(blcnt);
		pvo.setStartPage(startPg);
		pvo.setEndPage(endPg);
		
		List<BoardVo> articles = boardDao.getBoardList(bvo);
		
		// all content saved before forwarding 
		resultMap.put("articles", articles);
		resultMap.put("pvo", pvo);
		return resultMap;
	}

	@Override
	public int writePro(BoardVo bvo) {
		return boardDao.writePro(bvo);
	}

	@Override
	public BoardVo getContent(BoardVo bvo) {
		boardDao.upCount(bvo);
		return boardDao.getBoardList(bvo).get(0);
	}

	@Override
	public int updatePro(BoardVo bvo) {
		return boardDao.updatePro(bvo);
	}

	@Override
	public int deletePro(int bno) {
		return boardDao.deletePro(bno);
	}
	


}
