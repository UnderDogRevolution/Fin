package com.movie.sns.chat.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.chat.model.vo.ChatRoom;
@Repository
public class ChatDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

		
	/** 채팅 리스트조회
	 * @return chatRoomList
	 */
	public List<ChatRoom> chatRoomList(int memberNo) {
		
		
		return sqlSession.selectList("chatMapper.chatRoomList" , memberNo);
	}
}
