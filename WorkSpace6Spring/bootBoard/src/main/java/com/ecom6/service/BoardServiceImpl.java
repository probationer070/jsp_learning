package com.ecom6.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom6.dao.BoardDao;
import com.ecom6.vo.BoardVo;
import com.ecom6.vo.PageVo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public Map<String, Object> getBoardList(BoardVo bvo, PageVo pvo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int totArticle = boardDao.TotArticle(bvo);
		bvo.setStart(1);
		bvo.setEnd(6);
		List<BoardVo> articles = boardDao.getBoardList(bvo);
		
		// all content saved before forwarding 
		resultMap.put("totArticle", totArticle);
		resultMap.put("articles", articles);
		return resultMap;
	}

}
