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
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		String flag = req.getParameter("flag");
		// 미리 세션여부에 따라 장바구니 삭제를 방지하기 위해 미리 저장
		cartService.setCartList(hCartList);
		if(session.getAttribute("ssKey")!=null) {
			ssKey = (MemberVO) session.getAttribute("ssKey");
			// 고객 정보를 미리 저장해 둠
			ovo.setMem_id(ssKey.getMem_id());
			url ="cartlist";

		} else {
			msg = "로그인이 필요합니다.";
			url = "/login";
		}
		
		switch (flag) {
		case "add": 
			hCartList = cartService.addCart(ovo);
			msg="장바구니에 추가했습니다";
			break;
		case "update": 
			hCartList = cartService.updateCart(ovo);
			msg="장바구니에 수정했습니다";
			break;
		case "delete": 
			cartService.deleteCart(ovo);
			msg="장바구니에 삭제했습니다";
			break;
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		session.setAttribute("ssKey", ssKey);
		session.setAttribute("hCartList", hCartList);
		return page;
	}
	
	@GetMapping("/cartProc")
	public String cartProcGet(HttpServletRequest req,
						   HttpServletResponse res,
						   OrderVO ovo,
						   Model model) {
		return cartProc(req, res, ovo, model);
	}
	
	@GetMapping("/cartlist")
	public String cartList(HttpServletRequest req,
						   HttpServletResponse res,
						   OrderVO ovo,
						   Model model) {
		
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		Hashtable<Integer, OrderVO> hCartList = (Hashtable<Integer, OrderVO>) session.getAttribute("hCartList");
	
		String content = "custom/CartList.jsp";
 		model.addAttribute("content", content);
		session.setAttribute("hCartList", hCartList); // ???
 		return "Main";
	}
}
