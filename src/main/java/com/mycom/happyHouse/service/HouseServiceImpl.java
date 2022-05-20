package com.mycom.happyHouse.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.happyHouse.dao.HouseDao;
import com.mycom.happyHouse.dto.house.HouseDealDto;
import com.mycom.happyHouse.dto.house.HouseInfoDto;
import com.mycom.happyHouse.dto.house.HouseSearchParamDto;
import com.mycom.happyHouse.dto.house.HouseSearchResultDto;
import com.mycom.happyHouse.dto.house.InterestDto;
import com.mycom.happyHouse.dto.house.SubwayDto;

@Service
public class HouseServiceImpl implements HouseService{

	@Autowired
	HouseDao dao;
	
	//통합 검색 일반
	@Override
	public HouseSearchResultDto getSearchHouseInfo(HouseSearchParamDto dto) {
		List<HouseInfoDto> list = null;
		HouseSearchResultDto result = new HouseSearchResultDto();
		try {
			int count = dao.getCountHouseInfo(dto);
			list = dao.getSearchHouseInfo(dto);
			
			result.setCount(count);
			result.setList(list);
			result.setResult(1);
		}catch (Exception e) {
			e.printStackTrace();
			result.setResult(0);
			return result;
		}
		return result;
	}
	
	//관심 아파트 검색
	@Override
	public HouseSearchResultDto getSearchHouseInfoByInterest(HouseSearchParamDto dto) {
		List<HouseInfoDto> list = null;
		HouseSearchResultDto result = new HouseSearchResultDto();
		try {
			int count = dao.getCountHouseInfoByInterest(dto);
			list = dao.getSearchHouseInfoByInterest(dto);
			
			result.setCount(count);
			result.setList(list);
			result.setResult(1);
			
		}catch (Exception e) {
			e.printStackTrace();
			result.setResult(0);
			return result;
		}
		return result;
	}
	
	@Override
	public HouseSearchResultDto getHouseInfoByAptCode(int aptCode) {
		HouseInfoDto dto = null;
		HouseSearchResultDto result = new HouseSearchResultDto();
		try {
			dto = dao.getHouseInfoByAptCode(aptCode);
			
			if(dto == null) {
				result.setResult(1);
				result.setHouseInfoDto(null);
				return result;
			}
			
			dto.setHouseDealList(dao.getHouseDealList(aptCode));
			
			List<SubwayDto> subwayList = dao.getSubwayList(aptCode);
			
			
			if(subwayList != null) {
				subwayList.sort((a,b)-> a.getDistance().compareTo(b.getDistance()) );
				if(subwayList.size() > 3) subwayList = subwayList.subList(0, 3);
			}
			
			dto.setSubwayList(subwayList);
			result.setHouseInfoDto(dto);
			result.setResult(1);
			
		}catch (Exception e) {
			e.printStackTrace();
			result.setResult(0);
			return result;
		}
		
		return result;
	}

	@Override
	public int insertInterestApart(InterestDto dto) {
		try {
			return dao.insertInterestApart(dto);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int deleteInterestApart(InterestDto dto) {
		try {
			return dao.deleteInterestApart(dto);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}	


}
