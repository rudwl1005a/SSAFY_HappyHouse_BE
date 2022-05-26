package com.mycom.happyHouse.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycom.happyHouse.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSockChatHandler extends TextWebSocketHandler {
	private List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();
	
    private final ObjectMapper objectMapper;
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload {}", payload);
        System.out.println(payload);

        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        System.out.println(chatMessage);
        
        for(WebSocketSession sess : sessions) {
        	this.sendMessage(sess, chatMessage);
        }
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        log.info("접속 : {}",  session);
        //접속자 수 보여주려면 여기서도 메세지 보내야함.
    }
   
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        log.info("퇴장 : {}",  session);
      //접속자 수 보여주려면 여기서도 메세지 보내야함.
    }
    
    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
        	System.out.println(message);
        	System.out.println(new TextMessage(objectMapper.writeValueAsString(message)));
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}