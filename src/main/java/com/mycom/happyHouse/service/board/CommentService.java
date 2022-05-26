package com.mycom.happyHouse.service.board;

import java.util.List;

import com.mycom.happyHouse.dto.board.CommentDto;

public interface CommentService {
	public List<CommentDto> commentList(int boardId);
	public List<CommentDto> recommentList(int boardId);
	
	public int insertComment(CommentDto dto);
	public int insertRecomment(CommentDto dto);
	
	public int deleteComment(int commentId);
	public int deleteRecomment(int commentId);
}
