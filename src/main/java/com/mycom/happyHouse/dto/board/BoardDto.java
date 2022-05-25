package com.mycom.happyHouse.dto.board;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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
public class BoardDto {
	private int boardId;
	private String userId;
	private String boardCode; 
	private String title;
	private String content;
	private LocalDateTime regDt;
	private int readCount;

	private boolean sameUser;
	
	public void setRegDt(Date regDt) {
		this.regDt = LocalDateTime.ofInstant(regDt.toInstant(), ZoneId.systemDefault()); // for Mybatis Date Mapping
	}
}
