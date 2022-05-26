package com.mycom.happyHouse.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class ChatMessage {
	public enum MessageType{
		ENTER,TALK
	}
	private MessageType type;	// enter talk
	private String sender;
	private String message;
}
