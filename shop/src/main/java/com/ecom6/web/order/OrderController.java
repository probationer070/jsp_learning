package com.ecom6.web.order;

import java.util.HashMap;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecom6.VO.mem.MemberVO;
import com.ecom6.VO.order.OrderVO;
import com.ecom6.service.cart.CartService;
import com.ecom6.wrapper.order.OrderWrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	// 규칙 1. 서비스에서 트랜잭션을 걸어야 한다.
	// 규칙 2. 서로 다른 업무에서 해당 업무 이외의 업무를 호출하지 않는다.
	// 규칙 3. 타 업무가 필요할 때는 Wrapper 클래스를 만들어서 사용한다
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	OrderWrapper orderWrapper;
	
	@GetMapping("/orderProc")
	public String orderProc(HttpServletRequest req,
						   HttpServletResponse res,
						   OrderVO ovo,
						   Model model) {
		HttpSession session = req.getSession();
		String msg = null;
		String url = null;
		MemberVO ssKey = (MemberVO) session.getAttribute("ssKey");
		Hashtable<Integer, OrderVO> hCartList = null;
		if(ssKey!=null) {
			hCartList = cartService.getCartList();
			HashMap<String, Object> reMap = orderWrapper.orderProc(ovo, hCartList);
			msg = (String) reMap.get("msg");
			url = (String) reMap.get("url");
			// 주문하고 재고는 하나 줄고
		} else {
			msg = "로그인이 필요합니다.";
			url = "/login";
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		session.setAttribute("ssKey", ssKey);
		session.setAttribute("hCartList", hCartList);
		return "MsgPage";
	}
	
	@GetMapping("/orderlist")
	public String orderList(HttpServletRequest req,
						   HttpServletResponse res,
						   OrderVO ovo,
						   Model model) {
		
		String msg;
		String url;
		String page;
		HttpSession session = req.getSession();
		MemberVO ssKey = (MemberVO) session.getAttribute("ssKey");
		if(ssKey!=null) {
			// 데이터 받아서 저장
			model.addAttribute("content", "custom/OrderList.jsp");
		} else {
			msg = "로그인이 필요합니다.";
			url = "/login";
			model.addAttribute("url", url);
			model.addAttribute("msg", msg);
			page = "MsgPage";
		}
		session.setAttribute("ssKey", ssKey);
		return "Main";
	}
}
