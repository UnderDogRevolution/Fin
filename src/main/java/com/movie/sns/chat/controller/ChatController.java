package com.movie.sns.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.movie.sns.chat.model.service.ChatService;
import com.movie.sns.chat.model.vo.ChatRoom;
import com.movie.sns.member.model.vo.Member;



@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("/chat/*")
public class ChatController {
	
	// 채팅방 넘어올시 가져올 것
	// 내가 포함된 채팅 조회
	// chat 넘어올시
	// 채팅방조회(내가등록된 채팅번호)
	
	// 모달 클릭시 동작
	@Autowired
	private ChatService service;
	
	@RequestMapping(value="myChat", method=RequestMethod.GET)
	public String mainPageForward(Model model ,@ModelAttribute("loginMember")Member loginMember
				,ChatRoom room) {
		System.out.println(loginMember.getMemberNo());
		int memberNo = loginMember.getMemberNo();
		System.out.print(memberNo);
		
		  List<ChatRoom> chatRoomList = service.chatRoomList(memberNo);
		  if(chatRoomList != null) {
			  for(ChatRoom list : chatRoomList) {
				 
				  System.out.println(list.getFreindNo());
			  }
		  }
		  System.out.println(chatRoomList); 
		  model.addAttribute("chatRoomList",chatRoomList); 
		  int friendNo = room.getFreindNo();
		 
		
		//String message = "apc'de'f";		
		//String[] one = message.split("'");
		//System.out.println(one[0] + "'" +"리소시스머시기 이미지 경로"+ "'" +one[1]);
		// 조건 메세지에 이미지 태그가 있는 경우 없는경우 나누기
			
		
		
		return "chat/chat";
	}
	
	
		
	
}
