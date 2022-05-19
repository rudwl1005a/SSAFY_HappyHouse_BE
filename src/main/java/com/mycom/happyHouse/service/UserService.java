package com.mycom.happyHouse.service;

import java.util.List;

import com.mycom.happyHouse.entity.User;

public interface UserService {
	List<User> list();
	User detail(String userId);
	User insert(User user);
	User update(String userId, User user);
	void delete(String userId);
}
