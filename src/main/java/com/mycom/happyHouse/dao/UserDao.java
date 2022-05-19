package com.mycom.happyHouse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycom.happyHouse.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByUserId(String userId);
}
