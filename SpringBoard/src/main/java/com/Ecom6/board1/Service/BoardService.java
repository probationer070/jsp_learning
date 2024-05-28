package com.Ecom6.board1.Service;

import java.util.Map;

import com.Ecom6.board1.model.BoardDTO;
import com.Ecom6.board1.model.PageDTO;

public interface BoardService {
	public Map<String, Object> getArticles(BoardDTO searchDto, PageDTO pdto);

	public int writePro(BoardDTO bdto);

	public BoardDTO getContent(BoardDTO bdto);
	// public BoardDTO getContent(int bno);

	public int updatePro(BoardDTO bdto);

	public int deletePro(int bno);

}
