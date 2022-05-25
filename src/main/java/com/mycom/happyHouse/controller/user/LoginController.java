package com.mycom.happyHouse.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.dto.user.UserDto;
import com.mycom.happyHouse.service.user.JwtService;
import com.mycom.happyHouse.service.user.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService service;
	@Autowired
	private JwtService jwtService;

	@PostMapping(value = "/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody UserDto loginUser, HttpServletResponse response) {
		
		System.out.println("loginUser : " + loginUser);

		UserDto user = service.detail(loginUser.getUserId());
		
		System.out.println("user : " + user);
		
		Map<String, String> map = new HashMap<>();
		if (user.getPassword().equals(loginUser.getPassword())) {
			
			map.put("result", "success");
			map.put("userId", user.getUserId());
			map.put("password", user.getPassword());
			map.put("name", user.getName());
			map.put("userCode", user.getUserCode());
			map.put("introduce", user.getIntroduce());
			map.put("email", user.getEmail());
			map.put("gender", user.getGender());
			map.put("phone", user.getPhone());
			
			String token = jwtService.createToken(user.getUserId(), (1000 * 60 * 60)); // 1시간
			map.put("token", token);
			System.out.println("token : " + token);
			
			response.setHeader("authorization", token);

			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		}
		map.put("result", "fail");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/logout")
	public ResponseEntity<Map<String, String>> logout(HttpServletResponse response) {
		
		response.setHeader("authorization", "");
		
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}

}
