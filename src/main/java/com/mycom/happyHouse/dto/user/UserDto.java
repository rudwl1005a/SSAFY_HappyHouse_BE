package com.mycom.happyHouse.dto.user;

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
public class UserDto {
	private int userNo;
	private String userCode;
	private String name;
	private String password;
	private String userId;
	
	private String token;
}
