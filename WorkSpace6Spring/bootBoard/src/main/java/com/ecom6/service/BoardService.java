package com.ecom6.service;

import java.util.Map;

import com.ecom6.vo.BoardVo;
import com.ecom6.vo.PageVo;

public interface BoardService {

	public Map<String, Object> getBoardList(BoardVo bvo, PageVo pvo);

}
