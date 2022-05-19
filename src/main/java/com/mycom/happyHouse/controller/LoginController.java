package com.mycom.happyHouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.entity.User;
import com.mycom.happyHouse.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService service;

	@PostMapping(value = "/login")
	public ResponseEntity<Map<String, String>> login(User loginUser, HttpSession session) {

		User user = service.detail(loginUser.getUserId());
		Map<String, String> map = new HashMap<>();
		if (user != null) {
			session.setAttribute("user", user);

			map.put("result", "success");
			map.put("userId", user.getUserId());
			map.put("password", user.getPassword());
			map.put("name", user.getName());
			map.put("authority", Integer.toString(user.getAuthority()));

			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		}
		map.put("result", "fail");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
	}

}
