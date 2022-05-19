package com.mycom.happyHouse.service;

import java.util.List;

import com.mycom.happyHouse.dto.SidoGugunDongDto;

public interface AddressService {
	public List<SidoGugunDongDto> getSido();
	public List<SidoGugunDongDto> getGugunInSido(String sido);
	public List<SidoGugunDongDto> getDongInGugun(String gugun);
}
