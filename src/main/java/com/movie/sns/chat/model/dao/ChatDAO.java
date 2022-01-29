package com.movie.sns.chat.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.chat.model.vo.ChatMessage;
import com.movie.sns.chat.model.vo.ChatRoom;
import com.movie.sns.member.model.vo.Member;
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

	
	/** 채팅방안에있는 사람조회
	 * @param frNo
	 * @return member
	 */
	public Member searchMember(int friendNo) {
		return sqlSession.selectOne("chatMapper.searchMember",friendNo);
	}


	/** 채팅방 메세지 조회
	 * @param chatNo
	 * @return message
	 */
	public List<ChatMessage> searchMessage(String chatNo) {
		return sqlSession.selectList("chatMapper.searchMessage",chatNo);
	}


	/** 채팅방 메세지 삽입
	 * @param cm
	 * @return result
	 */
	public int insertMessage(ChatMessage cm) {
		
		return sqlSession.insert("chatMapper.insertMessage" , cm);
	}
}
