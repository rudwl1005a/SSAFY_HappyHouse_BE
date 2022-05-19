package com.mycom.happyHouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.happyHouse.dto.NoticeDto;

@Mapper
public interface NoticeDao {
	public NoticeDto detail(int boardId);
	public List<NoticeDto> list();
	public int insert(NoticeDto dto);
	public int update(NoticeDto dto);
	public int delete(int boardId);
}
