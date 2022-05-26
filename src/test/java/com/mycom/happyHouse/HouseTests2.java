package com.mycom.happyHouse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycom.happyHouse.dao.AddressDao;
import com.mycom.happyHouse.dao.HouseDao;
import com.mycom.happyHouse.dto.house.HouseDealDto;
import com.mycom.happyHouse.dto.house.HouseInfoDto;
import com.mycom.happyHouse.dto.house.HouseSearchParamDto;
import com.mycom.happyHouse.dto.house.HouseSearchResultDto;
import com.mycom.happyHouse.dto.house.InterestDto;
import com.mycom.happyHouse.dto.house.SidoGugunDongDto;
import com.mycom.happyHouse.dto.house.SubwayDto;
import com.mycom.happyHouse.service.AddressService;
import com.mycom.happyHouse.service.HouseService;

@SpringBootTest
class HouseTests2 {

	@Autowired
	AddressDao addressDao;
	@Autowired
	AddressService addressSrvice;
	
	@Autowired
	HouseDao houseDao;
	@Autowired
	HouseService houseService;
	
	
	//@Test
	void loadAddressConponent() {
		//주소 DAO 생성 확인
		assertNotNull(addressSrvice);
		assertNotNull(addressDao);
	}
	
	
	//@Test
	void testSearchAddress() {
		//주소 테스트
//		List<SidoGugunDongDto> list = service.getDongInGugun("11110");
//		for(SidoGugunDongDto dto : list) {
//			System.out.println(dto);
//		}
	}
	
	
	@Test
	void loadHouseConponent() {
		//House DAO 생성 확인
		System.out.println("loadHouseConponent()");
		assertNotNull(houseService);
		assertNotNull(houseDao);
	}
	
	
	@Test
	void testSearchHouseSearch() {
		//House 통합 검색 확인
		System.out.println("testSearchHouse()");
		
		HouseSearchParamDto dto = new HouseSearchParamDto();
		dto.setLimit(10);
		dto.setOffset(1);
		dto.setGugunCode("11110");
		dto.setUserId("123");
		System.out.println(dto);
		
		HouseSearchResultDto result = houseService.getSearchHouseInfoByInterest(dto);
		if(result.getResult() == 0) {
			System.out.println("houseService.getSearchHouseInfo() : 실패");
			return;
		}
		
		for(HouseInfoDto house : result.getList()) {
			System.out.println(house);
		}
	}
	@Test//관심 아파트 삽입 및 삭제
	void testInterest() {
		
		System.out.println("testInsertInterest()");
		
		InterestDto dto = new InterestDto("123", 6, null);
		
		System.out.println(houseService.insertInterestApart(dto));
		//System.out.println(houseService.deleteInterestApart(dto));
		
	}
	//@Test
	void testSearchHouseInfo() {
		//가까운 지하철 확인
		System.out.println("testSearchHouseInfo()");
		
//		System.out.println(houseService.getHouseInfoByAptCode(1));
//		
//		List<HouseDealDto> list = houseService.getHouseDealList(1);
//		if(list == null) return;
//		for(HouseDealDto house : list) {
//			System.out.println(house);
//		}
		
//		List<SubwayDto> list = houseDao.getSubwayList(1);				
//		for(SubwayDto house : list) {
//			System.out.println(house);
//		}
	}
}
