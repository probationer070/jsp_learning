package com.ecom6.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom6.service.BoardService;
import com.ecom6.vo.BoardVo;
import com.ecom6.vo.PageVo;
import com.ecom6.vo.Pageinfo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		// int Total = boardService.getTotArticle();
		//model.addAttribute("total", Total);
		return "redirect:boardList";
	}
	
	@RequestMapping("/boardList")
	public String boardList(HttpServletRequest req, HttpServletResponse res, 
			Model model, PageVo pvo, BoardVo bvo) {
		
		Map<String, Object> reMap = boardService.getBoardList(bvo, pvo);
		
		model.addAttribute("totArticle", reMap.get("totArticle"));
		model.addAttribute("articles", reMap.get("articles"));
		// model.addAttribute("pdto", reMap.get("pdto"));
		// model.addAttribute("sdto", pvo);
		// model.addAttribute("pblock", Pageinfo.PAGE_OF_BLOCK);
		
		return "board/boardlist";
	}
}
