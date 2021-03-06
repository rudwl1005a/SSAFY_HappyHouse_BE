package com.mycom.happyHouse.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.happyHouse.dto.user.UserDto;

@Mapper
public interface UserDao {
	List<UserDto> list();
	UserDto detail(String userId);
	int insert(UserDto user);
	int update(UserDto user);
	int delete(String userId);
}
