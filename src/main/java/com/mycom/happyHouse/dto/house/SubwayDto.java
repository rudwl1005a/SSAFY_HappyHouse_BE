package com.mycom.happyHouse.dto.house;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubwayDto {
	String subway_id;
	String line;
	String station;
	String lat;
	String lng;
	String distance;
}
