package com.Ecom6.board1.model.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Ecom6.board1.model.BoardDAO;
import com.Ecom6.board1.model.BoardDTO;

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
	public int getTotArticleCnt(BoardDTO bdto) {
		return sqlSession.selectOne(namespace + "getTotArticleCnt", bdto);
	}

	@Override
	public int writePro(BoardDTO bdto) {
		// System.out.println(bdto.toString());
		return sqlSession.insert(namespace + "writePro", bdto);
	}

	@Override
	public BoardDTO getContent(BoardDTO bdto) {
		return (BoardDTO) sqlSession.selectOne(namespace + "getArticles", bdto);
	}

	@Override
	public void upCount(BoardDTO bdto) {
		sqlSession.update(namespace + "upCount", bdto);
	}
	
	@Override
	public int updatePro(BoardDTO bdto) {
		return sqlSession.update(namespace + "updatePro", bdto);
	}

	@Override
	public int deletePro(int bno) {
		return sqlSession.delete(namespace + "deletePro", bno);
	}




	
}
