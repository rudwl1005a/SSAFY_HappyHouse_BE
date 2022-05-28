package com.mycom.happyHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.dto.house.HouseInfoDto;
import com.mycom.happyHouse.dto.house.HouseSearchParamDto;
import com.mycom.happyHouse.dto.house.HouseSearchResultDto;
import com.mycom.happyHouse.dto.house.InterestDto;
import com.mycom.happyHouse.service.HouseService;

@RestController
public class interestController {

	@Autowired
	HouseService houseService;
	
	@GetMapping(value="/{userId}/interest/aparts") 
	private ResponseEntity<HouseSearchResultDto> houseList(@PathVariable String userId, HouseSearchParamDto dto) {
		System.out.println("call Get /" + userId + "/interest/aparts" + dto);
		dto.setUserId(userId);
		HouseSearchResultDto result = houseService.getSearchHouseInfoByInterest(dto);
		System.out.println(result.getCount());
		if(result.getResult() == 1) {
			System.out.println("result : Success" );
			return new ResponseEntity<HouseSearchResultDto>(result, HttpStatus.OK);
		}
		else {
			System.out.println("result : Failed" );
			return new ResponseEntity<HouseSearchResultDto>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/{userId}/interest/aparts") 
	private ResponseEntity<Integer> insertInterestApt(@PathVariable String userId,@RequestBody InterestDto dto) {
		System.out.println("call POST /" + userId + "/interest/aparts");
		System.out.println(dto);
		dto.setUserId(userId);
		int result = houseService.insertInterestApart(dto);
		
		if(result == 1) {
			System.out.println("result : Success" );
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
		else {
			System.out.println("result : Failed" );
			return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping(value="/{userId}/interest/aparts/{aptCode}") 
	private ResponseEntity<Integer> getInterestApt(@PathVariable String userId, @PathVariable int aptCode) {
		System.out.println("call DELETE /" + userId + "/interest/aparts");
		
		int result = houseService.deleteInterestApart( new InterestDto(userId, aptCode, null) );
		if(result == 1) {
			System.out.println("result : Success" );
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
		else {
			System.out.println("result : Failed" );
			return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
