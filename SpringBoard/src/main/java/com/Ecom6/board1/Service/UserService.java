package com.Ecom6.board1.Service;

import javax.servlet.http.HttpSession;

import com.Ecom6.board1.model.UserVO;

public interface UserService {

	UserVO getUser(UserVO userVO);

	void logout(HttpSession session);

}
