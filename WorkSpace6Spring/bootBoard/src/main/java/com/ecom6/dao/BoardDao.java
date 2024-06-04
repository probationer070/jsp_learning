package com.ecom6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecom6.vo.BoardVo;

@Mapper
public interface BoardDao {

	int TotArticle(BoardVo bvo);

	List<BoardVo> getBoardList(BoardVo bvo);
}
