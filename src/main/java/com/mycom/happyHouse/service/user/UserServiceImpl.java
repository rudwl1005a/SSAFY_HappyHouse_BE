package com.mycom.happyHouse.service.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.happyHouse.dao.board.BoardDao;
import com.mycom.happyHouse.dao.board.CommentDao;
import com.mycom.happyHouse.dao.user.UserDao;
import com.mycom.happyHouse.dto.user.UserDto;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	@Autowired
	BoardDao boardDao;
	@Autowired
	CommentDao commentDao;

	@Override
	public List<UserDto> list() {
		return dao.list();
	}

	@Override
	public UserDto detail(String userId) {
		return dao.detail(userId);
	}

	@Override
	public int insert(UserDto user) {
		return dao.insert(user);
	}

	@Override
	public int update( UserDto user) {
		return dao.update(user);
	}

	@Override
	public int delete(String userId) {
		// 대댓글 삭제 -> 댓글 삭제 -> 게시글 조회수 삭제 -> 게시글 삭제 -> 회원 탈퇴
		commentDao.deleteRecommentByUserId(userId);
		commentDao.deleteCommentByUserId(userId);
		boardDao.boardReadCountDeleteByUserId(userId);
		boardDao.boardDeleteByUserId(userId);
		
		return dao.delete(userId);
	}

}
