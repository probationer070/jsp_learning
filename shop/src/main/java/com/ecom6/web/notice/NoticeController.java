package com.ecom6.web.notice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecom6.VO.mem.MemberVO;
import com.ecom6.VO.notice.NoticeVO;
import com.ecom6.common.vo.PageVO;
import com.ecom6.service.notice.NoticeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@GetMapping(value={"/notice", "/admin/notice"})
	public String noticeIndex(HttpServletRequest req, 
							HttpServletResponse res,
							NoticeVO nvo,
							PageVO pgVo,
							Model model) {
		String content = null;
		String page=null;
		HttpSession session = req.getSession();
		MemberVO ssKey = (MemberVO) session.getAttribute("ssKey");
		Map<String, Object> reSet = noticeService.getNotices(nvo, pgVo);
		if(ssKey!=null) {
			if(ssKey.getM_role().equals("admin")) {
				content = "../notice/NoticeList.jsp";
				page = "admin/Main";
			} else {
				content = "notice/NoticeList.jsp";
				page = "Main";
			}
		} else {
			content = "notice/NoticeList.jsp";
			page = "Main";
		}
		model.addAttribute("content", content);	
		model.addAttribute("nvo", reSet.get("NoticeList"));	
		model.addAttribute("pgVo", reSet.get("pgVo"));	
		model.addAttribute("noticeTot", reSet.get("noticeTot"));	
		return page;
	}
	
	@GetMapping("/NoticeInForm")
	public String NoticeInform(HttpServletRequest req, 
								HttpServletResponse res,
								NoticeVO nvo, // 커스텀 정보
								Model model) {
		String page=null;
		String content = null;
		HttpSession session = req.getSession();
		MemberVO ssKey = (MemberVO) session.getAttribute("ssKey");
		if (session.getAttribute("ssKey") != null) {
			session.setAttribute("ssKey", ssKey);
			if (ssKey.getM_role().equals("admin")) {
				content = "../notice/NoticeInForm.jsp";
				model.addAttribute("content", content);
				page = "admin/Main";
			} else {
				page = "redirect:/";
			}
		} else {
			page = "redirect:/";
		}
		return page;
	}
}
