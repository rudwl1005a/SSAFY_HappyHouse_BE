package com.mycom.happyHouse.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycom.happyHouse.dto.HouseDealDto;
import com.mycom.happyHouse.dto.HouseInfoDto;
import com.mycom.happyHouse.dto.HouseSearchParamDto;
import com.mycom.happyHouse.dto.HouseSearchResultDto;
import com.mycom.happyHouse.dto.SubwayDto;

public interface HouseService {
	
	HouseSearchResultDto getSearchHouseInfo(HouseSearchParamDto dto);
	
	HouseInfoDto getHouseInfoByAptCode(int aptCode);
	
	List<HouseDealDto> getHouseDealList(int aptCode);
	
}
