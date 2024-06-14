package com.ecom6.web.cart;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecom6.VO.mem.MemberVO;
import com.ecom6.VO.order.OrderVO;
import com.ecom6.service.cart.CartService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	
	@SuppressWarnings("unchecked")
	@PostMapping("/cartProc")
	public String cartProc(HttpServletRequest req,
						   HttpServletResponse res,
						   OrderVO ovo,
						   Model model) {
		String page = "MsgPage";
		String msg = null;
		String url = null;
		HttpSession session = req.getSession();
		MemberVO ssKey = null;
		Hashtable<Integer, OrderVO> hCartList = null;
		if(session.getAttribute("hCartList")==null) {
			hCartList = new Hashtable<>();			
		} else {
			hCartList = (Hashtable<Integer, OrderVO>) session.getAttribute("hCartList");
		}
		cartService.setCartList(hCartList);
		
		if(session.getAttribute("ssKey")!=null) {
			ssKey = (MemberVO) session.getAttribute("ssKey");
			// 고객 정보를 미리 저장해 둠
			ovo.setMem_id(ssKey.getMem_id());
			url ="cartList";
		} else {
			msg = "로그인이 필요합니다.";
			url = "/login";
		}
		String flag = req.getParameter("flag");
		switch (flag) {
		case "add": 
			break;
		case "update": 
			break;
		case "delete": 
			break;
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		model.addAttribute("ssKey", ssKey);
		model.addAttribute("hCartList", hCartList);
		
		return page;
	}
	
	@GetMapping("/cartProc")
	public String cartProcGet(HttpServletRequest req,
						   HttpServletResponse res,
						   OrderVO ovo,
						   Model model) {
		return cartProc(req, res, ovo, model);
	}
}
