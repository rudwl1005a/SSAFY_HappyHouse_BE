package com.mycom.happyHouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.entity.User;
import com.mycom.happyHouse.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	// 상세
	@GetMapping(value = "/users/{userId}")
	public User detail(@PathVariable String userId) {
		return service.detail(userId);
	}

	// 목록
	@GetMapping(value = "/users")
	public List<User> list() {
		return service.list();
	}

	// 등록
	@PostMapping(value = "/users")
	public ResponseEntity<Map<String, String>> register(User user) {

		Map<String, String> map = new HashMap<>();
		try {
			service.insert(user);
			map.put("result", "success");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "fail");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// 수정
	@PutMapping(value = "/users/{userId}")
	public User modify(User user, @PathVariable String userId) {
		return service.update(userId, user);
	}

	// 삭제
	@DeleteMapping(value = "/users/{userId}")
	public int delete(@PathVariable String userId, HttpSession session) {
		try {
			service.delete(userId);
			session.invalidate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
