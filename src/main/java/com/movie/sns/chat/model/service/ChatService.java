package com.movie.sns.chat.model.service;

import java.util.List;



import com.movie.sns.chat.model.vo.ChatRoom;


public interface ChatService {
	
	
	// 채팅목록 조회
	List<ChatRoom> chatRoomList(int memberNo);

}
