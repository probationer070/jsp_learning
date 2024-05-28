package com.Ecom6.board1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecom6.board1.Service.UserService;
import com.Ecom6.board1.model.UserDAO;
import com.Ecom6.board1.model.UserVO;

@Controller
@RequestMapping("/member")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:login";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest req, HttpServletResponse res, 
			Model model, UserVO userVO) {
		logger.info("로그인 화면 > "+ userVO.toString());
		
		model.addAttribute("id", req.getParameter("id"));
		model.addAttribute("password", req.getParameter("password"));
		return "login";
	}

	@RequestMapping("/loginPro")
	public String loginPro(HttpServletRequest req, HttpServletResponse res, 
			Model model, UserVO userVO, HttpSession session) {
		
		userVO.setId(req.getParameter("id"));
		userVO.setPassword(req.getParameter("password"));
		UserVO user = userService.getUser(userVO);
		
		// logger.info("유저 정보 : "+ user.toString());
		
		String msg = "";
		if (user != null) {
			msg = user.getId() + "님 환영합니다.";
			session = req.getSession();
			session.setAttribute("user", user.getId());
			model.addAttribute("newView", "../boardlist");
		} else {
			msg = "로그인 실패";
			model.addAttribute("newView", "login");
		}
		
		
		model.addAttribute("msg", msg);
		return "MsgPg2";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res, 
			Model model, UserVO userVO, HttpSession session) {
		userService.logout(session);
		
		String msg = "logout";
		model.addAttribute("msg", msg);
		model.addAttribute("newView", "login");
		
		return "MsgPg2";
	}
}


