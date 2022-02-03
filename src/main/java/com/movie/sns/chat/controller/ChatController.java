package com.movie.sns.chat.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.movie.sns.chat.model.service.ChatService;
import com.movie.sns.chat.model.vo.ChatMessage;
import com.movie.sns.chat.model.vo.ChatRoom;
import com.movie.sns.chat.model.vo.ChatRoomJoin;
import com.movie.sns.common.Util;
import com.movie.sns.member.model.vo.Member;

@Controller
@SessionAttributes({ "loginMember", "chatNo" })
@RequestMapping("/chat/*")
public class ChatController {

	// 채팅방 넘어올시 가져올 것
	// 내가 포함된 채팅 조회
	// chat 넘어올시
	// 채팅방조회(내가등록된 채팅번호)

	// 모달 클릭시 동작
	@Autowired
	private ChatService service;

	@RequestMapping(value = "myChat", method = RequestMethod.GET)
	public String mainPageForward(Model model, @ModelAttribute("loginMember") Member loginMember, ChatRoom room) {
		System.out.println(loginMember.getMemberNo());
		int memberNo = loginMember.getMemberNo();

		List<ChatRoom> chatRoomList = service.chatRoomList(memberNo);
		model.addAttribute("chatRoomList", chatRoomList);

		// String message = "apc'de'f";
		// String[] one = message.split("'");
		// System.out.println(one[0] + "'" +"리소시스머시기 이미지 경로"+ "'" +one[1]);
		// 조건 메세지에 이미지 태그가 있는 경우 없는경우 나누기

		return "chat/chat";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "selectChatRoom" ,method = RequestMethod.GET)
	public String selectChatRoom(@ModelAttribute("loginMember") Member loginMember) {
		int memberNo = loginMember.getMemberNo();
		List <ChatRoom> chatList = service.chatRoomList(memberNo);
		
		System.out.println(chatList);
		return  new Gson().toJson(chatList);
	}
	
	@ResponseBody
	@RequestMapping(value = "selectchatting" , method = RequestMethod.GET)
	public String selectchatting(ChatMessage cm) {
		
		
		return null;	
	}
	
	
	
	// 채팅방 입장 -> 사실상 해당 메세지 조회\
	@ResponseBody
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String searchJoin(String chatNo, String memberNo, String frNo, Model model) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("이건 채팅방번호다" + chatNo); // 채팅방 번호
		System.out.println("내번호" + memberNo);// 회원번호 일단가져옴 loginMemberNo 에도 있음 ㅋ
		System.out.println("나말고 나랑대화하는아이 번호" + frNo);
		int friendNo = Integer.parseInt(frNo);
		Member member = service.searchMember(friendNo);

		System.out.println(member.getMemberNo());
		List<ChatMessage> message = service.searchMessage(chatNo);
		// 내가아닌 참여자 정보 가져올려면 memberNo 필요
		// 해당 방 상대회원조회
		model.addAttribute("chatNo", chatNo);
		System.out.println("해당 방 메세지다" + message);
		// List<ChatMessage> message = service.searchMessage(chatNo , memberNo);
		result.put("memberNo", member.getMemberNo());
		result.put("memberName", member.getMemberName());
		result.put("memberNickName", member.getMemberNickName());
		// result.put("memberImg", memberImg);
		result.put("message", message);
		return new Gson().toJson(result);
	}

	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public int deleteChat(ChatRoomJoin join) {

		// 참여 미참여 // 미참여 두명일시 채팅방 삭제 아닐시 상태변경
		int result = service.deleteChat(join);

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "imgUp", method = RequestMethod.POST)
	public String imgUp(HttpSession session , @RequestParam("images") MultipartFile file) {
		String webPath = "/resources/images/chat/"; // (DB에 저장되는 경로)
		String fileName = file.getOriginalFilename();
		String rename = Util.fileRename(fileName);
		String serverPath = session.getServletContext().getRealPath(webPath);
		
		try {
			file.transferTo(new File(serverPath+"/"+rename));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return webPath+rename;
	}
	
		@ResponseBody
		@RequestMapping(value = "updateJoinUp", method = RequestMethod.POST)
		public int updateJoinUp(ChatMessage cm) {

			// 참여 미참여 // 미참여 두명일시 채팅방 삭제 아닐시 상태변경
			int result = service.updateJoinUp(cm);

			return result;
		}

}
