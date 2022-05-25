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
public class ShopSearchParamDto {
	
	private String category;
	private String lat;
	private String lng;	
}
