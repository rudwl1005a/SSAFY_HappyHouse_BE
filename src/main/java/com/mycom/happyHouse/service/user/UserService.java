package com.mycom.happyHouse.service.user;

import java.util.List;

import com.mycom.happyHouse.dto.user.UserDto;

public interface UserService {
	List<UserDto> list();
	UserDto detail(String userId);
	int insert(UserDto user);
	int update(UserDto user);
	int delete(String userId);
}
