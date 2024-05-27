package com.Ecom6.board1.model;

import java.util.List;

public interface BoardDAO {

	List<BoardDTO> getArticles(BoardDTO bdto);

	int getTotArticleCnt();

	int writePro(BoardDTO bdto);

	BoardDTO getContent(int bno);

	int updatePro(BoardDTO bdto);

	int deletePro(int bno);




}
