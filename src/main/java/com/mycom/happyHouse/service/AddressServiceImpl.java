package com.mycom.happyHouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.happyHouse.dao.AddressDao;
import com.mycom.happyHouse.dto.SidoGugunDongDto;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressDao dao;
	
	@Override
	public List<SidoGugunDongDto> getSido(){
		List<SidoGugunDongDto> list = null;
		
		try {
			list = dao.getSido();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return null;
			
		}
		
		return list;
	}
	
	@Override
	public List<SidoGugunDongDto> getGugunInSido(String sido){
		List<SidoGugunDongDto> list = null;
		
		try {
			
			list = dao.getGugunInSido(sido);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return null;
			
		}
		
		return list;	
	}
	
	@Override
	public List<SidoGugunDongDto> getDongInGugun(String gugun){
		List<SidoGugunDongDto> list = null;
		
		try {
			
			list = dao.getDongInGugun(gugun);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return null;
			
		}
		
		return list; 
	}
	
	
}

