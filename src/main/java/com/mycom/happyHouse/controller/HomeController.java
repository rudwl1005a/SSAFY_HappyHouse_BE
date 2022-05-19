package com.mycom.happyHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/aparts")
	private String home() {
		return "/apartSearch.html";
	}
	
}
