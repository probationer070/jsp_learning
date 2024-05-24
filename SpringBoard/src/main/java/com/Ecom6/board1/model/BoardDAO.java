package com.Ecom6.board1.model;

import java.util.List;

public interface BoardDAO {

	List<BoardDTO> getArticles(BoardDTO bdto);

	int getTotArticleCnt();

}
