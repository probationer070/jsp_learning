package com.ecom6.web.mem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom6.VO.mem.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	@GetMapping("/")
	public String index(HttpServletRequest req, 
						HttpServletResponse res) {
		MemberVO ssKey = null;
		String page = null;
		HttpSession session = req.getSession();
		if(session.getAttribute("ssKey")!=null) {
			if (ssKey.getM_role().equals("admin")) {
				ssKey = (MemberVO) session.getAttribute("ssKey");
				page = "redirect:/admin/";				
			} else {
				page = "index";
			}
		} else {
			page = "index";
		}
		return "index";
	}
	
	@GetMapping("/admin/")
	public String admin(HttpServletRequest req, 
			HttpServletResponse res) {
		return "admin/index";
	}
	
	@GetMapping("/pwCheck")
	public String pwCheck(HttpServletRequest req, 
						HttpServletResponse res) {
		return "popup/pwCheck_popup";
	}
	
	
}
