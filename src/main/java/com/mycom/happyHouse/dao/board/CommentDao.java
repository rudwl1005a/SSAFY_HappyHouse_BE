package com.mycom.happyHouse.dao.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.happyHouse.dto.board.CommentDto;

@Mapper
public interface CommentDao {
	public List<CommentDto> commentList(int boardId);
	public List<CommentDto> recommentList(int boardId);
	
	public int insertComment(CommentDto dto);
	public int insertRecomment(CommentDto dto);
	
	public int deleteComment(int commentId);
	public int deleteCommentByParentId(int parentId);
//	public int deleteRecomment(int commentId);
	/*
	 * <delete id="deleteRecomment" parameterType="int">
		DELETE FROM comment WHERE comment_id = #{commentId}
	</delete>
	 */
}
