package com.mycom.happyHouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.happyHouse.dao.NoticeDao;
import com.mycom.happyHouse.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao dao;
	
	@Override
	public NoticeDto detail(int boardId) {
		return dao.detail(boardId);
	}

	@Override
	public List<NoticeDto> list() {
		return dao.list();
	}

	@Override
	public int insert(NoticeDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(NoticeDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int delete(int boardId) {
		return dao.delete(boardId);
	}

}
