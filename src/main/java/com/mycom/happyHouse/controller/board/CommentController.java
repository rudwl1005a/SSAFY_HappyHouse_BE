package com.mycom.happyHouse.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.service.board.CommentService;

@RestController
public class CommentController {

	@Autowired
	CommentService service;
	
}
