package com.ecom6.web.mem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
		// 회원 정보 가져오기
		MemberVO svo = memberService.getMember(mvo);
		
		if (svo!=null) {
			if (svo.getM_role().equals("admin")) {
				url = "/admin/";
			}
			MemberVO ssKey = svo; 
			msg=svo.getM_name()+"님 반갑습니다.";
			session.setAttribute("ssKey", ssKey);	
		} else {
			msg = "비밀번호가 일치하지 않습니다.";
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return "MsgPage";
	}
	
	@PostMapping("logoutProc")
	public String logoutProc(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("ssKey");
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("logoutProc")
	public String getlogoutProc(HttpServletRequest req) {
		return logoutProc(req);
	}
	
	@GetMapping("/join")
	public String joinMember(HttpServletRequest req, 
							HttpServletResponse res, 
							MemberVO mvo, Model model) {
		return "member/MemberJoin";
	}
	
	@Transactional
	@PostMapping("/registerProc")
	public String registerProc(
			HttpServletRequest req, 
			HttpServletResponse res,
			MemberVO mvo, Model model) {
		String msg = null;
		String url = "/";
		
		int r = memberService.memberJoin(mvo);
		if (r>0) {
			msg = "회원가입 성공";
		} else {
			msg = "회원가입 실패";
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return "MsgPage";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("/info")
	public String infoView(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("ssKey");
		model.addAttribute("mvo", mvo);
		model.addAttribute("content", "member/Memberinfo.jsp"); 
		return "Main";
	}

	@PostMapping("/memUpdateForm")
	public String updateForm(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("ssKey");
		model.addAttribute("mvo", mvo);
		model.addAttribute("content", "member/UpdateForm.jsp"); 
		return "Main";
	}
	
	@Transactional
	@PostMapping("/memUpdateProc")
	public String memUpdateProc(
			HttpServletRequest req, 
			HttpServletResponse res,
			MemberVO mvo, Model model) {
		
		HttpSession session = req.getSession();
		
		String msg = null;
		
		int r = memberService.memberUpdate(mvo);
		if (r>0) {
			msg = "수정 성공";
		} else {
			msg = "수정 실패";
		}
		
		session.removeAttribute("ssKey");
		session.invalidate();
		model.addAttribute("url", "/");
		model.addAttribute("msg", msg);
		return "MsgPage";
	}
	
	@GetMapping("/notice")
	public String test() {
		return "test";
	}
	
}
