package com.mycom.happyHouse.service.board;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.happyHouse.dao.board.CommentDao;
import com.mycom.happyHouse.dto.board.CommentDto;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentDao dao;

	@Override
	public List<CommentDto> commentList(int boardId) {
		return dao.commentList(boardId);
	}

	@Override
	public List<CommentDto> recommentList(int boardId) {
		return dao.recommentList(boardId);
	}

	@Override
	public int insertComment(CommentDto dto) {
		return dao.insertComment(dto);
	}

	@Override
	public int insertRecomment(CommentDto dto) {
		return dao.insertRecomment(dto);
	}

	@Override
	public int deleteComment(int commentId) {
		// 대댓글 삭제 -> 댓글 삭제
		dao.deleteCommentByParentId(commentId); // parentId가 commentId인것 삭제
		return dao.deleteComment(commentId);
	}

	@Override
	public int deleteRecomment(int commentId) {
		return dao.deleteComment(commentId);
	}

}
