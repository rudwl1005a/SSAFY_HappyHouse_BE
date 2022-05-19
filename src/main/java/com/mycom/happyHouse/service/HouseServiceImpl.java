package com.mycom.happyHouse.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.happyHouse.dao.HouseDao;
import com.mycom.happyHouse.dto.HouseDealDto;
import com.mycom.happyHouse.dto.HouseInfoDto;
import com.mycom.happyHouse.dto.HouseSearchParamDto;
import com.mycom.happyHouse.dto.HouseSearchResultDto;
import com.mycom.happyHouse.dto.SubwayDto;

@Service
public class HouseServiceImpl implements HouseService{

	@Autowired
	HouseDao dao;
	
	@Override
	public HouseSearchResultDto getSearchHouseInfo(HouseSearchParamDto dto) {
		List<HouseInfoDto> list = null;
		HouseSearchResultDto result = null;		
		try {
			result = new HouseSearchResultDto();
			
			int count = dao.getCountHouseInfo(dto);
			list = dao.getSearchHouseInfo(dto);
			
			result.setCount(count);
			result.setList(list);
						
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public HouseInfoDto getHouseInfoByAptCode(int aptCode) {
		HouseInfoDto dto = null;
		try {
			dto = dao.getHouseInfoByAptCode(aptCode);
			
			if(dto == null) return null;
			
			dto.setHouseDealList(dao.getHouseDealList(aptCode));
			
			List<SubwayDto> subwayList = dao.getSubwayList(aptCode);
			
			
			if(subwayList != null) {
				subwayList.sort((a,b)-> a.getDistance().compareTo(b.getDistance()) );
				if(subwayList.size() > 3) subwayList = subwayList.subList(0, 3);
			}
			dto.setSubwayList(subwayList);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return dto;
	}

	@Override
	public List<HouseDealDto> getHouseDealList(int aptCode) {
		List<HouseDealDto> list = null; 
		try {
			list = dao.getHouseDealList(aptCode);
		
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return list;
	}


}
