package com.mycom.happyHouse.dto;

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
public class HouseSearchParamDto {
	
	private int limit;
	private int offset;
	
	private String aptKeyword;
	private String sidoCode;
	private String gugunCode;
	private String dongCode;
	
	//private String minPrice;
	//private String maxPrice;
	//private String minArea;
	//private String maxArea;
	
}
