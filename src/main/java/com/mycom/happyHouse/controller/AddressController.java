package com.mycom.happyHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happyHouse.dto.SidoGugunDongDto;
import com.mycom.happyHouse.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@GetMapping(value="/sido")
	ResponseEntity<List<SidoGugunDongDto>> sido() throws Exception {
		System.out.println("call /address/sido ()");
		return new ResponseEntity<List<SidoGugunDongDto>>(addressService.getSido(), HttpStatus.OK);
	}
	
	@GetMapping(value="/gugun/{sidoCode}")
	ResponseEntity<List<SidoGugunDongDto>> gugun(@PathVariable String sidoCode) {
		System.out.println("call /address/gugun () : ");
		List<SidoGugunDongDto> list =  addressService.getGugunInSido(sidoCode);
		
		if(list != null ){//&& !list.isEmpty()) {
			System.out.println("result : Success");
			return new ResponseEntity<List<SidoGugunDongDto>>(list, HttpStatus.OK);
		}
		else {
			System.out.println("result : failed");
			return new ResponseEntity<List<SidoGugunDongDto>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/dong/{gugunCode}")
	ResponseEntity<List<SidoGugunDongDto>> dong(@PathVariable String gugunCode) {
		System.out.println("call /address/dong () : ");
		List<SidoGugunDongDto> list =  addressService.getDongInGugun(gugunCode);
		
		if(list != null){// && !list.isEmpty()) {
			System.out.println("result : Success");
			return new ResponseEntity<List<SidoGugunDongDto>>(list, HttpStatus.OK);
		}
		else {
			System.out.println("result : Failed" );
			return new ResponseEntity<List<SidoGugunDongDto>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
