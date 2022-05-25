package com.mycom.happyHouse.controller.user;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.service.user.JwtService;

@RestController
@RequestMapping("/security")
public class SecurityContoller {

	@Autowired
	private JwtService securityService;

	@GetMapping("/create/token")
	public Map<String, Object> createToken(@RequestParam(value = "subject") String subject) {
		String token = securityService.createToken(subject, (2 * 1000 * 60)); // 2분
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result", token);
		return map;
	}

	@GetMapping("/get/subject")
	public Map<String, Object> getSubject(@RequestParam(value = "token") String token) {
		String subject = securityService.getSubject(token);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result", subject);
		return map;
	}
}
