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
public class HouseSearchResultDto {	
	int result;
	List<HouseInfoDto> list;
	HouseInfoDto houseInfoDto;
	int count;
}
