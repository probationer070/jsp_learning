package com.Ecom6.board1.Service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecom6.board1.model.UserDAO;
import com.Ecom6.board1.model.UserVO;

@Service(value="UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO getUser(UserVO userVO) {
		return userDAO.getUser(userVO);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate(); 
	}

}
