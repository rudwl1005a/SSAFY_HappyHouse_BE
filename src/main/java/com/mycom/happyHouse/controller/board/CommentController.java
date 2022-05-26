package com.mycom.happyHouse.controller.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.dto.board.CommentDto;
import com.mycom.happyHouse.service.board.CommentService;

@RestController
public class CommentController {

	@Autowired
	CommentService service;
	
	@PostMapping("/comments/{boardId}")
	private ResponseEntity<String> commentInsert(@RequestBody CommentDto commentDto, HttpServletRequest request) {

		System.out.println(commentDto);
		
		int result;
		if(commentDto.getParentId() > 0) { // 대댓글
			result = service.insertRecomment(commentDto);
		} else { // 댓글
			result = service.insertComment(commentDto);
		}

		if (result == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/comments/{commentId}")
	private ResponseEntity<String> commentDelete(@PathVariable int commentId, HttpServletRequest request) {

		System.out.println(commentId);
		
		int result = service.deleteComment(commentId);

		if (result == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/comments/re/{commentId}")
	private ResponseEntity<String> recommentDelete(@PathVariable int commentId, HttpServletRequest request) {
		
		System.out.println(commentId);
		
		int result = service.deleteRecomment(commentId);
		
		if (result == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
