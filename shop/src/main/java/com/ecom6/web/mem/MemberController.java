package com.ecom6.web.mem;

import java.util.Map;

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
	
	@PostMapping(value={"logoutProc", "/admin/logoutProc"})
	public String logoutProc(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("ssKey");
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping(value={"logoutProc", "/admin/logoutProc"})
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


	@PostMapping("/memUpdateForm")
	public String updateForm(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("ssKey");
		model.addAttribute("mvo", mvo);
		model.addAttribute("content", "member/UpdateForm.jsp"); 
		return "Main";
	}
	
	@GetMapping("/info")
	public String infoView(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("ssKey");
		model.addAttribute("mvo", mvo);
		model.addAttribute("content", "member/MemberInfo.jsp"); 
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
	
	@GetMapping("/memberMgt")
	public String memberMgt(HttpServletRequest req, 
							HttpServletResponse res,
							MemberVO mvo, Model model) {
		String msg=null;
		String url=null;
		String page="Main";
		HttpSession session = req.getSession();
		MemberVO ssKey = (MemberVO) session.getAttribute("ssKey");
		if(ssKey!=null) {
			if(ssKey.getM_role().equals("admin")) {
				mvo.setM_role(ssKey.getM_role());
				Map<String, Object> reSet = memberService.getMemberList(mvo);
				msg = (String) reSet.get("msg");
				model.addAttribute("members", reSet.get("members"));
				model.addAttribute("memTot", reSet.get("memTot"));
				model.addAttribute("msg", msg);
				model.addAttribute("content", "admin/memberList.jsp");			
			} else {
				session.removeAttribute("ssKey");
				session.invalidate();
				msg = "올바른 접근이 아닙니다.";
				url = "/";
				page = "MsgPage";
			}
		} else {
			session.removeAttribute("ssKey");
			session.invalidate();
			msg = "로그인이 필요합니다.";
			url = "/login";
			page = "MsgPage";
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return page;
	}
	
	@PostMapping("/memberMgt")
	public String memberMgtPost(HttpServletRequest req, 
			HttpServletResponse res,
			MemberVO mvo, Model model) {
		return memberMgt(req, res, mvo, model);
	}
	
	@PostMapping("/customInfo")
	public String customInfo(HttpServletRequest req, 
							HttpServletResponse res,
							MemberVO mvo, // 커스텀 정보
							Model model) {
		String msg=null;
		String url=null;
		String page=null;
		HttpSession session = req.getSession();
		MemberVO ssKey = (MemberVO) session.getAttribute("ssKey");
		if(ssKey!=null) {
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("mvo", mvo);	
				model.addAttribute("content", "member/MemberInfo.jsp");	
				page = "Main";
			} else {
				session.removeAttribute("ssKey");
				session.invalidate();
				msg = "올바른 접근이 아닙니다.";
				url = "/";
				page = "MsgPage";
			}
		} else {
			session.removeAttribute("ssKey");
			session.invalidate();
			msg = "로그인이 필요합니다.";
			url = "/login";
			page = "MsgPage";
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return page;
	}
	
	@GetMapping("/customInfo")
	public String GetcustomInfo(HttpServletRequest req, 
			HttpServletResponse res,
			MemberVO mvo, // 커스텀 정보
			Model model) {
		return customInfo(req, res, mvo, model);
	}
	
	
	
	@GetMapping("/admin/info")
	public String infoView(HttpServletRequest req, 
							HttpServletResponse res,
							MemberVO mvo, // 커스텀 정보
							Model model) {
		String msg=null;
		String url=null;
		String page=null;
		HttpSession session = req.getSession();
		MemberVO ssKey = (MemberVO) session.getAttribute("ssKey");
		if(ssKey!=null) {
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("mvo", ssKey);	
				model.addAttribute("content", "../admin/MemberInfo.jsp");	
				page = "admin/Main";
			} else {
				session.removeAttribute("ssKey");
				session.invalidate();
				msg = "올바른 접근이 아닙니다.";
				url = "/login";
				page = "MsgPage";
				model.addAttribute("url", url);
				model.addAttribute("msg", msg);
			}
		} else {
			page="redirect:/";
		}
		return page;
	}
	
	@PostMapping("/admin/memUpdateForm")
	public String AdminupdateForm(HttpServletRequest req, Model model) {
		
		String msg=null;
		String url=null;
		String page=null;
		HttpSession session = req.getSession();
		MemberVO ssKey = (MemberVO) session.getAttribute("ssKey");
		if(ssKey!=null) {
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("mvo", ssKey);	
				model.addAttribute("content", "../admin/UpdateForm.jsp"); 
				page = "admin/Main";
			} else {
				session.removeAttribute("ssKey");
				session.invalidate();
				msg = "올바른 접근이 아닙니다.";
				url = "/login";
				page = "MsgPage";
				model.addAttribute("url", url);
				model.addAttribute("msg", msg);
			}
		} else {
			page="redirect:/";
		}
		return page;
	}
	
	@GetMapping("/admin/memUpdateProc")
	public String AdminGetmemUpdateProc(HttpServletRequest req, 
									 HttpServletResponse res,
									 MemberVO mvo, Model model) {
		return AdminmemUpdateProc(req, res, mvo, model);
	}
	
	@PostMapping("/admin/memUpdateProc")
	public String AdminmemUpdateProc(HttpServletRequest req, 
									 HttpServletResponse res,
									 MemberVO mvo, Model model) {
		String msg = null;
		String page =null;
		String url=null;
		HttpSession session = req.getSession();
		MemberVO ssKey = (MemberVO) session.getAttribute("ssKey");
		
		if(ssKey!=null) {
			if(ssKey.getM_role().equals("admin")) {
				int r = memberService.memberUpdate(mvo);
				if (r>0) {
					msg = "관리자 정보 수정 성공";
				} else {
					msg = "관리자 정보 수정 실패";
				}
			} else {
				msg = "올바른 접근이 아닙니다.";
				url = "/login";
				page = "MsgPage";
			}
		} else {
			page="redirect:/";
		}
		session.removeAttribute("ssKey");
		session.invalidate();
		model.addAttribute("url", "/");
		model.addAttribute("msg", msg);
		return "MsgPage";

	}
}
