package com.ecom6.web.mem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecom6.VO.mem.MemberVO;
import com.ecom6.service.mem.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/loginProc")
	public String loginProc(HttpServletRequest req, 
							HttpServletResponse res, 
							MemberVO mvo, Model model) {
		// 세션 가지고 오기
		HttpSession session = req.getSession();
		String msg = null;
		String url = "/";
		// 세션 확인
		// 회원 정보 가져오기
		log.info("test==>"+mvo.toString());
		MemberVO svo = memberService.getMember(mvo);
		
		if (svo!=null) {
			MemberVO ssKey = svo;
			
//			log.info(svo.toString()); 
//			log.info(ssKey.toString());
			 
			msg=svo.getM_name()+"님 반갑습니다.";
			session.setAttribute("ssKey", ssKey);	
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return "MsgPage";
	}
	
	@PostMapping("/logoutProc")
	public String logoutProc(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("ssKey");
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String joinMember(HttpServletRequest req, 
							HttpServletResponse res, 
							MemberVO mvo, Model model) {
		return "member/MemberJoin";
	}
}
