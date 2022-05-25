package com.mycom.happyHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.dto.house.HouseInfoDto;
import com.mycom.happyHouse.dto.house.HouseSearchParamDto;
import com.mycom.happyHouse.dto.house.HouseSearchResultDto;
import com.mycom.happyHouse.dto.house.ShopSearchParamDto;
import com.mycom.happyHouse.dto.house.ShopSearchResultDto;
import com.mycom.happyHouse.service.HouseService;

@RestController
@RequestMapping("/aparts")
public class HouseController {
	@Autowired
	HouseService houseService;
	
	@GetMapping(value="/all") 
	private ResponseEntity<HouseSearchResultDto> houseList(HouseSearchParamDto dto) {
		System.out.println("call /aparts?" + dto);
		HouseSearchResultDto result = houseService.getSearchHouseInfo(dto);
		
		if(result.getResult() == 1){// && !list.isEmpty()) {
			System.out.println("result : Success" );
			return new ResponseEntity<HouseSearchResultDto>(result, HttpStatus.OK);
		}
		else {
			System.out.println("result : Failed" );
			return new ResponseEntity<HouseSearchResultDto>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{aptCode}") 
	private ResponseEntity<HouseInfoDto> houseDetail(@PathVariable int aptCode) {
		System.out.println("call /aparts/" + aptCode);
		HouseSearchResultDto result = houseService.getHouseInfoByAptCode(aptCode);
		
		if(result.getResult() == 1) {
			System.out.println("result : Success" );
			return new ResponseEntity<HouseInfoDto>(result.getHouseInfoDto(), HttpStatus.OK);
		}
		else {
			System.out.println("result : Failed" );
			return new ResponseEntity<HouseInfoDto>(result.getHouseInfoDto(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value="/shops") 
	private ResponseEntity<ShopSearchResultDto> shopList(ShopSearchParamDto dto) {
		System.out.println("call /aparts/shops" + dto);
		ShopSearchResultDto result = houseService.getShopList(dto);
		if(result.getResult() == 1) {
			System.out.println("result : Success" );
			return new ResponseEntity<ShopSearchResultDto>(result, HttpStatus.OK);
		}
		else {
			System.out.println("result : Failed" );
			return new ResponseEntity<ShopSearchResultDto>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
