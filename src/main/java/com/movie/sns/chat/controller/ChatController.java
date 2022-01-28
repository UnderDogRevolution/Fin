package com.movie.sns.chat.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.movie.sns.chat.model.service.ChatService;
import com.movie.sns.chat.model.vo.ChatMessage;
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
		  System.out.println(chatRoomList); 
		  model.addAttribute("chatRoomList",chatRoomList); 
		 
		
		//String message = "apc'de'f";		
		//String[] one = message.split("'");
		//System.out.println(one[0] + "'" +"리소시스머시기 이미지 경로"+ "'" +one[1]);
		// 조건 메세지에 이미지 태그가 있는 경우 없는경우 나누기
			
		
		
		return "chat/chat";
	}
	
	// 채팅방 입장 -> 사실상 해당 메세지 조회\
	@ResponseBody
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String searchJoin(String chatNo , String memberNo ,String frNo ) {
		HashMap<String, Object>  result = new HashMap<String, Object>(); 
		System.out.println("이건 채팅번호다"+chatNo); //채팅방 번호
		System.out.println("내번호" +memberNo);// 회원번호 일단가져옴 loginMemberNo 에도 있음 ㅋ
		System.out.println("나말고 나랑대화하는아이 번호" + frNo);
		int friendNo = Integer.parseInt(frNo);
		Member member = service.searchMember(friendNo);
		
		System.out.println(member.getMemberNo());
		List<ChatMessage> message = service.searchMessage(chatNo);
		// 내가아닌 참여자 정보 가져올려면 memberNo 필요 
		// 해당 방 상대회원조회
		System.out.println("해당 방 메세지다" + message);	
		//List<ChatMessage> message = service.searchMessage(chatNo , memberNo);
		result.put("memberNo" , member.getMemberNo());
		result.put("memberName", member.getMemberName());
		result.put("memberNickName",member.getMemberNickName());
		//result.put("memberImg", memberImg);
		result.put("message",message);
		return new Gson().toJson(result);
	}
	
}
