package com.ecom6.web.mem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	@GetMapping("/")
	public String index(HttpServletRequest req, 
						HttpServletResponse res) {
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
