package com.mycom.happyHouse.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycom.happyHouse.dto.house.HouseDealDto;
import com.mycom.happyHouse.dto.house.HouseInfoDto;
import com.mycom.happyHouse.dto.house.HouseSearchParamDto;
import com.mycom.happyHouse.dto.house.HouseSearchResultDto;
import com.mycom.happyHouse.dto.house.InterestDto;
import com.mycom.happyHouse.dto.house.ShopSearchParamDto;
import com.mycom.happyHouse.dto.house.ShopSearchResultDto;
import com.mycom.happyHouse.dto.house.SubwayDto;

public interface HouseService {
	//통합 검색 일반
	HouseSearchResultDto getSearchHouseInfo(HouseSearchParamDto dto);
	
	//관심 아파트 검색 일반
	HouseSearchResultDto getSearchHouseInfoByInterest(HouseSearchParamDto dto);
		
	//아파트 상세 검색
	HouseSearchResultDto getHouseInfoByAptCode(int aptCode);
	
	
	//관심 아파트 등록 및 삭제
	int insertInterestApart(InterestDto dto);
	
	int deleteInterestApart(InterestDto dto);
	
	ShopSearchResultDto getShopList(ShopSearchParamDto dto);
}
