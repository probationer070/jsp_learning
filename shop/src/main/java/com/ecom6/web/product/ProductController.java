package com.ecom6.web.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecom6.VO.PageVO;
import com.ecom6.VO.mem.MemberVO;
import com.ecom6.VO.product.ProductVO;
import com.ecom6.service.product.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

// 상품과 관련된 컨트롤러
@Slf4j
@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Value("${resources.location}")
	String resouresLocation;
	
	@GetMapping("/productMgt")
	public String productMgt(HttpServletRequest req, 
							HttpServletResponse res,
							Model model, PageVO pgVo) {
		String page=null;
		MemberVO ssKey = null;
		HttpSession session = req.getSession();
		if (session.getAttribute("ssKey") != null) {
			ssKey = (MemberVO) session.getAttribute("ssKey");
			// session이 있을 때 받아서 저장
			session.setAttribute("ssKey", ssKey);
			if (ssKey.getM_role().equals("admin")) {
				page = "admin/productMgt";
			} else {
				page = "redirect:/";	// 최초 화면으로 이동
			}
		} else {
			page = "redirect:/";
		}
		Map<String, Object> reSet = productService.getProductsList(pgVo);
		
		model.addAttribute("pcnt", reSet.get("pcnt"));
		model.addAttribute("productList", reSet.get("productList"));
		model.addAttribute("pgVo", pgVo);
		return page;
	}
	
	@GetMapping("/productInForm")
	public String productInForm(HttpServletRequest req, 
								HttpServletResponse res,
								Model model, PageVO pgVo) {
		String page=null;
		MemberVO ssKey = null;
		HttpSession session = req.getSession();
		if (session.getAttribute("ssKey") != null) {
			ssKey = (MemberVO) session.getAttribute("ssKey");
			// session이 있을 때 받아서 저장
			session.setAttribute("ssKey", ssKey);
			if (ssKey.getM_role().equals("admin")) {
				model.addAttribute("content", "admin/ProductInForm.jsp");
				page = "admin/productInForm";
			} else {
				page = "redirect:/";	// 최초 화면으로 이동
			}
		} else {
			page = "redirect:/";
		}
		return "Main";
	}
	
	@PostMapping("productMgtProc")
	public String productInProc(HttpServletRequest req, 
								HttpServletResponse res,
								Model model, PageVO pgVo, ProductVO pvo,
								@RequestParam("image2") MultipartFile file) {
		
		String msg = null;
		String url = null;
		MemberVO ssKey = null;
		HttpSession session = req.getSession();
		if (session.getAttribute("ssKey") != null) {
			ssKey = (MemberVO) session.getAttribute("ssKey");
			// session이 있다면 저장
			session.setAttribute("ssKey", ssKey);
			if (ssKey.getM_role().equals("admin")) {
				if(req.getParameter("flag")!=null) {
					String flag = req.getParameter("flag");
					// 업로드를 위한 패스 저장
					pvo.setPath(resouresLocation);
					if(flag.equals("insert")) {
						// insert 호출
						int r = productService.insertProduct(pvo, file);
						if (r > 0) {
							msg="상품등록성공!";
						} else {
							msg="상품등록성공!";							
						}
					} else if(flag.equals("update")) {
						// update 호출
					}
					url = "productMgt";
				}
			} else {
				url = "redirect:/";	// 최초 화면으로 이동
				msg = "잘못된 접근입니다!";
			}
		} else {
			url = "redirect:/";
			msg = "잘못된 접근입니다!";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "MsgPage";
	}
}
