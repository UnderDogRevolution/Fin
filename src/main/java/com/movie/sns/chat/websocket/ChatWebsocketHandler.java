package com.movie.sns.chat.websocket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.stereotype.Component;





import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.movie.sns.chat.model.service.ChatService;
import com.movie.sns.chat.model.vo.ChatMessage;
import com.movie.sns.member.model.vo.Member;

public class ChatWebsocketHandler extends TextWebSocketHandler {

	@Autowired
	private ChatService service;
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		sessions.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		 
		//System.out.println("전달 받은 내용 :" + message.getPayload());
		
		ObjectMapper objectMapper = new ObjectMapper();

		ChatMessage cm = objectMapper.readValue(message.getPayload(), ChatMessage.class);

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		cm.setCreateDate(sdf.format(new Date())); 
		

		int result = service.insertMessage(cm);
		if (result >0) {

			for (WebSocketSession wss : sessions) {
				int memberNo = ((Member)wss.getAttributes().get("loginMember")).getMemberNo();


				if (memberNo == cm.getTargetNo() || memberNo == cm.getMemberNo()) {
					System.out.println("상대 번호 " + cm.getTargetNo() +"내번호" + cm.getMemberNo());
					//wss.sendMessage(new TextMessage(message.getPayload()));
					wss.sendMessage(new TextMessage(new Gson().toJson(cm)));
				}

			}
		}

		super.handleTextMessage(session, message);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

		sessions.remove(session);
		super.afterConnectionClosed(session, status);
	}

	// 바이너리 메세지
	@Override
	public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
			
		ByteBuffer byteBuffer = message.getPayload();
		String fileName = "temp.jpg";
		System.out.println("파일요청옴");
		
	
	}
}
