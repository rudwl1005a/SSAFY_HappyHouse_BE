package com.mycom.happyHouse.dto.house;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HouseInfoDto {
	private int aptCode;
	private String aptName;
	private String dongCode;
	private String dongName;
	private String sidoName;
	private String gugunName;
	private int buildYear;
	private String jibun;
	private String lat;
	private String lng;	
	
	//최근 거래가
	private String recentPrice;
	private String maxPrice;
	private int dealCount;
	//유저가 관심 아파트로 지정했는지
	private int isUserInterest;
	
	private List<HouseDealDto> houseDealList;
	private List<SubwayDto> subwayList;
}
