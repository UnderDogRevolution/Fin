package com.movie.sns.chat.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.chat.model.dao.ChatDAO;
import com.movie.sns.chat.model.vo.ChatRoom;

@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatDAO dao;
	// 채팅 리스트 조회
	@Override
	public List<ChatRoom> chatRoomList(int memberNo) {
		
		
		return dao.chatRoomList(memberNo);
	}
	
	
	
	
}
