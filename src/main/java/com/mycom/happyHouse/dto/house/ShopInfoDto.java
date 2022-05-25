package com.mycom.happyHouse.dto.house;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShopInfoDto {
	int shopCode;
	String name; 
	String branchName; 
	String commercialCode; 
	String commercialName; 
	String classification; 
	String dongcode; 
	String jibun1; 
	String jibun2; 
	String building; 
	String buildingDong;
	String floor; 
	String ho; 
	String lat; 
	String lng;
}
