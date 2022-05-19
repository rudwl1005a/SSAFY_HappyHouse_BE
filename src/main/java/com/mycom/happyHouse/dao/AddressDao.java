package com.mycom.happyHouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.happyHouse.dto.SidoGugunDongDto;

@Mapper
public interface AddressDao {
	
	List<SidoGugunDongDto> getSido();
	List<SidoGugunDongDto> getGugunInSido(String sido);
	List<SidoGugunDongDto> getDongInGugun(String gugun);
	
}
