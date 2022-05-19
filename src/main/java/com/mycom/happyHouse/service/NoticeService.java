package com.mycom.happyHouse.service;

import java.util.List;

import com.mycom.happyHouse.dto.NoticeDto;

public interface NoticeService {
	public NoticeDto detail(int boardId);
	public List<NoticeDto> list();
	public int insert(NoticeDto dto);
	public int update(NoticeDto dto);
	public int delete(int boardId);
}
