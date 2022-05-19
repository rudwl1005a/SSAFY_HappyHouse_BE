package com.mycom.happyHouse.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.happyHouse.dao.UserDao;
import com.mycom.happyHouse.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public List<User> list() {
		return dao.findAll();
	}

	@Override
	public User detail(String userId) {
		return dao.findByUserId(userId);
	}

	@Override
	public User insert(User user) {
		return dao.save(user);
	}

	@Override
	public User update(String userId, User user) {
		User findUser = dao.findByUserId(userId);
		findUser.setUserId(user.getUserId());
		findUser.setPassword(user.getPassword());
		findUser.setName(user.getName());
		return dao.save(findUser);
	}

	@Override
	public void delete(String userId) {
		User user = dao.findByUserId(userId);
		int userNo = user.getUserNo();
		dao.deleteById(userNo);
	}

}
