package com.ecom6.service;

import java.util.Map;

import com.ecom6.vo.BoardVo;
import com.ecom6.vo.PageVo;

public interface BoardService {

	public Map<String, Object> getBoardList(BoardVo bvo, PageVo pvo);

	public int writePro(BoardVo bvo);

	public BoardVo getContent(BoardVo bvo);

	public int updatePro(BoardVo bvo);

	public int deletePro(int bno);

}
