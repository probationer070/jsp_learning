package com.Ecom6.board1.model;

import java.util.List;

public interface BoardDAO {

	List<BoardDTO> getArticles(BoardDTO bdto);

	int getTotArticleCnt(BoardDTO bdto);

	int writePro(BoardDTO bdto);

	BoardDTO getContent(BoardDTO bdto);

	int updatePro(BoardDTO bdto);

	int deletePro(int bno);

	void upCount(BoardDTO bdto);





}
