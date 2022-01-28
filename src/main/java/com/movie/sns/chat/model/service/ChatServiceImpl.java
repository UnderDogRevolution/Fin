package com.movie.sns.chat.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.chat.model.dao.ChatDAO;
import com.movie.sns.chat.model.vo.ChatMessage;
import com.movie.sns.chat.model.vo.ChatRoom;
import com.movie.sns.member.model.vo.Member;

@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatDAO dao;
	// 채팅 리스트 조회
	@Override
	public List<ChatRoom> chatRoomList(int memberNo) {
		
		
		return dao.chatRoomList(memberNo);
	}
	
	
	/** 채팅방안에있는 사람 조회
	 * return member
	 */
	@Override
	public Member searchMember(int friendNo) {
		
		return dao.searchMember(friendNo);
	}


	/** 채팅방 메세지조회
	 * return message
	 */
	@Override
	public List<ChatMessage> searchMessage(String chatNo) {

		
		return dao.searchMessage(chatNo);
	}
	
	
	
	
}
