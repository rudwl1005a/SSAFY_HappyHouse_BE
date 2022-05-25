package com.mycom.happyHouse.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.dto.user.UserDto;
import com.mycom.happyHouse.service.user.SecurityService;
import com.mycom.happyHouse.service.user.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService service;
//	@Autowired
//	private SecurityService securityService;

	@PostMapping(value = "/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody UserDto loginUser, HttpSession session) {
		
		System.out.println("loginUser : " + loginUser);

		UserDto user = service.detail(loginUser.getUserId());
		
		System.out.println("user : " + user);
		
		Map<String, String> map = new HashMap<>();
		if (user.getPassword().equals(loginUser.getPassword())) {
			session.setAttribute("user", user);

			map.put("result", "success");
			map.put("userId", user.getUserId());
			map.put("password", user.getPassword());
			map.put("name", user.getName());
			map.put("userCode", user.getUserCode());
//			String token = securityService.createToken(user.getUserId(), (1000 * 3600 *24)); // 1일
//			map.put("token", token);

			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		}
		map.put("result", "fail");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
	}

}
