package com.movie.sns.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/chat/*")
public class ChatController {
	
	// 채팅방 넘어올시 가져올 것
	// 내가 포함된 채팅 조회
	// chat 넘어올시
	// 채팅방조회(내가등록된 채팅번호)
	
	// 모달 클릭시 동작
	
	
	@RequestMapping(value="myChat", method=RequestMethod.GET)
	public String mainPageForward() {
		String message = "apc'de'f";		
		String[] one = message.split("'");
		System.out.println(one[0] + "'" +"리소시스머시기 이미지 경로"+ "'" +one[1]);
		// 조건 메세지에 이미지 태그가 있는 경우 없는경우 나누기
			
		
		
		return "chat/chat";
	}
	
	
		
	
}
