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
import com.Ecom6.board1.model.InterPginfo;
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
	public String article_list(HttpServletRequest req, HttpServletResponse res, 
			Model model, PageDTO pdto, BoardDTO searchDto) {
	
		logger.info("text ==> "+ searchDto.toString());
		// 서비스 호출
		Map<String, Object> reMap = boardService.getArticles(searchDto, pdto);
		
		// 결과를 가져오면
		// model에 저장		
		model.addAttribute("totArticle", reMap.get("totArticle"));
		model.addAttribute("articles", reMap.get("articles"));
		model.addAttribute("pdto", reMap.get("pdto"));
		model.addAttribute("sdto", searchDto);
		model.addAttribute("pblock", InterPginfo.PAGE_OF_BLOCK);
		
		return "boardlist";
	}	

	@RequestMapping(value = "/writeForm")
	public String writeForm(HttpServletRequest req, HttpServletResponse res, 
							Model model, PageDTO pdto, BoardDTO bdto) {
		model.addAttribute("article", bdto);
		model.addAttribute("pdto", pdto);
		return "writeForm";
	}	

	@RequestMapping(value = "/writePro")
	public String writePro(HttpServletRequest req, HttpServletResponse res, 
			Model model, PageDTO pdto, BoardDTO bdto) {

		bdto.setIp(req.getRemoteAddr());
		int	r = boardService.writePro(bdto);
		String msg = "";
		
		if (r > 0) {
			msg = "게시글 등록 성공";
		} else {
			msg = "게시글 등록 실패\\n관리자에게 문의";
		}
		
		model.addAttribute("newView", "boardlist?curPg="+pdto.getCurPg()+"&curBlock="+pdto.getCurBlock());
		model.addAttribute("msg", msg);
		// model.addAttribute("article", bdto);
		model.addAttribute("pdto", pdto);
		return "MsgPage";
	}	
	
	@RequestMapping(value = "/Content")
	public String content(HttpServletRequest req, HttpServletResponse res, 
							Model model, PageDTO pdto, BoardDTO bdto) {
		// int bno = Integer.parseInt(req.getParameter("bno"));
		// BoardDTO article = boardService.getContent(bno);
		BoardDTO article = boardService.getContent(bdto);

		
		model.addAttribute("article", article);
		model.addAttribute("pdto", pdto);
		return "Content";
	}
	
	@RequestMapping(value = "/update")
	public String update(HttpServletRequest req, HttpServletResponse res, 
							Model model, PageDTO pdto, BoardDTO bdto) {
		
		model.addAttribute("article", bdto);
		model.addAttribute("pdto", pdto);
		return "Update";
	}	
	
	@RequestMapping(value = "/updatePro")
	public String updatePro(HttpServletRequest req, HttpServletResponse res, 
			Model model, PageDTO pdto, BoardDTO bdto) {
		bdto.setIp(req.getRemoteAddr());
		int	r = boardService.updatePro(bdto);
		logger.info("r -> "+r);
		
		String msg = "";
		
		if (r > 0) {
			msg = "게시글 수정 성공";
		} else {
			msg = "게시글 수정 실패\\n관리자에게 문의";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("newView", "boardlist?curPg="+pdto.getCurPg()+"&curBlock="+pdto.getCurBlock());
		// model.addAttribute("article", bdto);
		model.addAttribute("pdto", pdto);
		return "MsgPage";
	}
	
	@RequestMapping(value = "/deletePro")
	public String delete(HttpServletRequest req, HttpServletResponse res, 
							Model model, PageDTO pdto, BoardDTO bdto) {
		int bno = Integer.parseInt(req.getParameter("bno"));
		int	r = boardService.deletePro(bno);
		String msg = "";
		
		if (r > 0) {
			msg = "게시글 삭제 성공";
		} else {
			msg = "게시글 삭제 실패\\n관리자에게 문의";
		}
		
		model.addAttribute("newView", "boardlist");
		model.addAttribute("msg", msg);
		model.addAttribute("article", bdto);
		model.addAttribute("pdto", pdto);
		return "MsgPage";
	}
}
