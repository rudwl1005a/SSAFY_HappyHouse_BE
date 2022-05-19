package com.mycom.happyHouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping(value = "/login")
	public String login(HttpSession session) {
		session.invalidate();
		return "/login.html";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/index.html";
	}

	@GetMapping(value = "/register")
	public String register() {
		return "/register.html";
	}
	
	@GetMapping(value = {"/", "/index"})
	public String index() {
		return "/index.html";
	}

	@GetMapping(value = "/userinfo")
	public String userinfo(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "/login.html";
		}
		return "/userInfo.html";
	}
}
