package com.movie.sns.chat.model.service;

import java.util.List;
import java.util.Map;

import com.movie.sns.chat.model.vo.ChatFriend;
import com.movie.sns.chat.model.vo.ChatMessage;
import com.movie.sns.chat.model.vo.ChatRoom;
import com.movie.sns.chat.model.vo.ChatRoomJoin;
import com.movie.sns.member.model.vo.Member;


public interface ChatService {
	
	
	// 채팅목록 조회
	List<ChatRoom> chatRoomList(int memberNo);
	
	// 채팅방 안에있는 놈 조회
	Member searchMember(int friendNo);
	
	// 해당채팅방 메세지 조회
	
	List<ChatMessage> searchMessage(String chatNo);

	
	// 상대 채팅방 참여 로 바꾸기
	int updateJoinUp(ChatMessage cm);
	
	// 채팅내용 삽입
	int insertMessage(ChatMessage cm);
	
	// 채팅방 나가기
	int deleteChat(ChatRoomJoin join);
	
	// 팔로워조회
	List<ChatFriend> searchFollower(ChatFriend chat);
	
	// 메세지 보내기
	Map<String, Object> goChatting(ChatRoom room);
	// 채팅 인물검색
	List<ChatFriend> searchPersion(ChatFriend chat);
	
	


}
