package com.Ecom6.board1.model.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Ecom6.board1.model.BoardDAO;
import com.Ecom6.board1.model.BoardDTO;
import com.Ecom6.board1.model.PageDTO;

@Repository(value="boardDAO")
public class BoardDaoImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private String namespace = "board1.model.BoardDAO.";

	@Override
	public List<BoardDTO> getArticles(BoardDTO bdto) {
		return sqlSession.selectList(namespace + "getArticles", bdto);
	}

	@Override
	public int getTotArticleCnt() {
		return sqlSession.selectOne(namespace + "getTotArticleCnt");
	}
}
