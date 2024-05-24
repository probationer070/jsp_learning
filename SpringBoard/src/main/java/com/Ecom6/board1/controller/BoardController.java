package com.Ecom6.board1.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecom6.board1.Service.BoardService;
import com.Ecom6.board1.model.BoardDTO;
import com.Ecom6.board1.model.PageDTO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// DI(Dependency Injection)을 함. 비즈니스 로직담당(Service)
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:boardlist";
	}
	
	@RequestMapping(value = "/boardlist")
	public String article_list(HttpServletRequest req, HttpServletResponse res, Model model, PageDTO pdto) {
		logger.info("리스트에 들어옴"+ pdto.toString());
		// 서비스 호출
		Map<String, Object> reMap = boardService.getArticles(pdto);
		
		// 결과를 가져오면
		// model에 저장		
		model.addAttribute("totArticle", reMap.get("totArticle"));
		model.addAttribute("articles", reMap.get("articles"));
		model.addAttribute("pdto", reMap.get("pdto"));
		
		return "boardlist";
	}	

	@RequestMapping(value = "/writeForm")
	public String writeForm(HttpServletRequest req, HttpServletResponse res, 
							Model model, PageDTO pdto, BoardDTO bdto) {
		model.addAttribute("article", bdto);
		model.addAttribute("pdto", pdto);
		return "write";
	}	

	@RequestMapping(value = "/writePro")
	public String writePro(HttpServletRequest req, HttpServletResponse res, 
			Model model, PageDTO pdto, BoardDTO bdto) {
		logger.info("작성페이지 : "+ pdto.toString());
		
		// Map<String, Object> reMap = boardService.writeArticles(bdto);
		
		return "boardlist";
	}
}
