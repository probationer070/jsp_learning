package com.Ecom6.board1.model.Impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Ecom6.board1.model.UserDAO;
import com.Ecom6.board1.model.UserVO;

@Repository(value="UserDAO")
public class UserDaoImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private String namespace = "board1.model.UserDAO.";

	@Override
	public UserVO getUser(UserVO userVO) {
		System.out.println(userVO);
		return sqlSession.selectOne(namespace + "getUser", userVO);
	}
}
