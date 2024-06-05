package com.ecom6.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom6.service.BoardService;
import com.ecom6.vo.BoardVo;
import com.ecom6.vo.PageVo;
import com.ecom6.vo.Pageinfo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	@GetMapping("/boardList")
	@PostMapping("/boardList")
	public String boardList(HttpServletRequest req, HttpServletResponse res, 
			Model model, PageVo pvo, BoardVo bvo) {
		
		Map<String, Object> reMap = boardService.getBoardList(bvo, pvo);
		log.info("TEST   pvo  ==>"+pvo);
		model.addAttribute("totArticle", reMap.get("totArticle"));
		model.addAttribute("articles", reMap.get("articles"));
		model.addAttribute("pvo", reMap.get("pvo"));
		model.addAttribute("svo", bvo);
		model.addAttribute("pblock", Pageinfo.PAGE_OF_BLOCK);
		
		return "board/boardlist";
	}
	
	@GetMapping("/writeForm")
	public String writeForm(Model model, PageVo pvo, BoardVo bvo) {
		model.addAttribute("article", bvo);
		model.addAttribute("pvo", pvo);
		return "board/writeForm";
	}
	
	@PostMapping("/writeForm")
	public String ReplyForm(Model model, PageVo pvo, BoardVo bvo) {
		model.addAttribute("article", bvo);
		model.addAttribute("pvo", pvo);
		return "board/writeForm";
	}
	
	@PostMapping(value = "/writePro")
	public String writePro(HttpServletRequest req, HttpServletResponse res, 
			Model model, PageVo pvo, BoardVo bvo) {

		bvo.setIp(req.getRemoteAddr());
		boardService.writePro(bvo);
		model.addAttribute("pvo", pvo);
		return "redirect:/boardList";
	}
	
	@Transactional
	@PostMapping(value = "/Content")
	public String content(Model model, PageVo pvo, BoardVo bvo) {
		BoardVo article = boardService.getContent(bvo);
		model.addAttribute("article", article);
		model.addAttribute("pvo", pvo);
		return "board/Content";
	}
	
	@PostMapping(value = "/update")
	public String update(Model model, PageVo pvo, BoardVo bvo) {
		
		model.addAttribute("article", bvo);
		model.addAttribute("pvo", pvo);
		return "board/Update";
	}	
	
	@PostMapping(value = "/updatePro")
	public String updatePro(HttpServletRequest req, HttpServletResponse res, 
			Model model, PageVo pvo, BoardVo bvo) {
		bvo.setIp(req.getRemoteAddr());
		int	r = boardService.updatePro(bvo);
		
		String msg = "";
		
		if (r > 0) {
			msg = "게시글 수정 성공";
		} else {
			msg = "게시글 수정 실패\\n관리자에게 문의";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("newView", "boardList?curPg="+pvo.getCurPg()+"&curBlock="+pvo.getCurBlock());
		model.addAttribute("pvo", pvo);
		return "board/MsgPage";
	}
	
	@PostMapping(value = "/deletePro")
	public String delete(HttpServletRequest req, HttpServletResponse res, 
							Model model, PageVo pvo, BoardVo bvo) {
		int bno = Integer.parseInt(req.getParameter("bno"));
		int	r = boardService.deletePro(bno);
		String msg = "";
		
		if (r > 0) {
			msg = "게시글 삭제 성공";
		} else {
			msg = "게시글 삭제 실패\\n관리자에게 문의";
		}
		
		model.addAttribute("newView", "boardList");
		model.addAttribute("msg", msg);
		model.addAttribute("article", bvo);
		model.addAttribute("pvo", pvo);
		return "board/MsgPage";
	}
}
