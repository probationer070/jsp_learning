package com.ecom6.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstContorller {
	
	@GetMapping("hi")
	public String hello(Model model) {
		model.addAttribute("username", "Hello");
		return "greetings";
	}
	
	@GetMapping("/")
	public String nice(Model model) {
		model.addAttribute("username", "Joshua");
		return "hello";
	}
}
