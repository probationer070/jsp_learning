package com.Ecom6.board1.Service;

import java.util.Map;

import com.Ecom6.board1.model.PageDTO;

public interface BoardService {
	public Map<String, Object> getArticles(PageDTO pdto);
	
	
}
