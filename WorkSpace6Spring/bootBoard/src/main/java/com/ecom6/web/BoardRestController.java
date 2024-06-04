package com.ecom6.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardRestController {
	
	@GetMapping("/h")
	public String hello() {
		return "안녕";
	}
}
