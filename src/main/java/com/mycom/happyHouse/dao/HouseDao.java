package com.mycom.happyHouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.happyHouse.dto.house.HouseDealDto;
import com.mycom.happyHouse.dto.house.HouseInfoDto;
import com.mycom.happyHouse.dto.house.HouseSearchParamDto;
import com.mycom.happyHouse.dto.house.InterestDto;
import com.mycom.happyHouse.dto.house.SubwayDto;

@Mapper
public interface HouseDao {
	//통합 검색 일반
	List<HouseInfoDto> getSearchHouseInfo(HouseSearchParamDto dto);
	//통합 검색 일반 개수
	int getCountHouseInfo(HouseSearchParamDto dto);
	//관심 아파트 검색
	List<HouseInfoDto> getSearchHouseInfoByInterest(HouseSearchParamDto dto);
	//관심 아파트 검색 개수
	int getCountHouseInfoByInterest(HouseSearchParamDto dto);
	
	//아파트 상세 검색
	HouseInfoDto getHouseInfoByAptCode(int aptCode);
	
	//아파트 거래 내역 검색
	List<HouseDealDto> getHouseDealList(int aptCode);
	
	//주변 지하철 검색
	List<SubwayDto> getSubwayList(int aptCode);
	
	//관심 아파트 삽입 및 삭제
	int insertInterestApart(InterestDto dto);
	
	int deleteInterestApart(InterestDto dto);
	
	
}
