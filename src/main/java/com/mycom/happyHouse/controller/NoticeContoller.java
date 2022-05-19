package com.mycom.happyHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.dto.NoticeDto;
import com.mycom.happyHouse.service.NoticeService;

@RestController
public class NoticeContoller {

	@Autowired
	NoticeService service;
	
	@GetMapping(value="/notices")
	public List<NoticeDto> list(){
		return service.list();
	}
	
	@GetMapping(value="/notices/{boardId}")
	public NoticeDto detail(@PathVariable int boardId) {
		return service.detail(boardId);
	}
	
	@PostMapping(value="/notices")
	public int insert(NoticeDto dto) {
		return service.insert(dto);
	}
	
	@PutMapping(value="/notices/{boardId}")
	public int update(NoticeDto dto, @PathVariable int boardId) {
		return service.update(dto);
	}
	
	@DeleteMapping(value="/notices/{boardId}")
	public int delete(@PathVariable int boardId) {
		return service.delete(boardId);
	}
}
