package com.movie.sns.chat.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.chat.model.vo.ChatFriend;
import com.movie.sns.chat.model.vo.ChatMessage;
import com.movie.sns.chat.model.vo.ChatRoom;
import com.movie.sns.chat.model.vo.ChatRoomJoin;
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


	/** 채팅방 참여자 수 조회
	 * @param chatRoomNo
	 * @return result 1 아니면 2
	 */
	public int selectJoinCount(ChatRoomJoin join) {
		
		return sqlSession.selectOne("chatMapper.selectJoinCount",join);
	}

	/** 상대방 채팅방 참여여부 조회
	 * @param cm
	 * @return result
	 */
	public int selectFriendJoin(ChatMessage cm) {
		return sqlSession.selectOne("chatMapper.selectFriendJoin" , cm);
	}

	/** 채팅방 미참여로 상태변경
	 * @param join
	 * @return result
	 */
	public int updateJoin(ChatRoomJoin join) {
		return sqlSession.update("chatMapper.updateJoin",join);
	}
	
	/** 채팅방 참여로 상태 변경
	 * @param cm
	 * @return result
	 */
	public int updateJoinUp(ChatMessage cm) {
		return sqlSession.update("chatMapper.updateJoinUp",cm);
	}
	

	/** 채팅방 삭제
	 * @param join
	 * @return result
	 */
	public int deleteChatRoom(ChatRoomJoin join) {
		
		return sqlSession.delete("chatMapper.deleteChatRoom" , join);
	}


	/** 팔로워한 사람 정보가져오기 // 검색 인원 조회하기
	 * @param memberNo
	 * @return rList
	 */
	public List<ChatFriend> searchFollower(ChatFriend chat) {
		return sqlSession.selectList("chatMapper.searchFollower", chat);
	}


	/** 두사람이 포함된 채팅방이 있는지 조회
	 * @return result
	 */
	public int searchChatRoomJoin(ChatRoom room) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("chatMapper.searchChatRoomJoin" , room);
	}


	/** 두사람이 참여하고있는 방 넘버 조회
	 * @param room
	 * @return chatRoomNo
	 */
	public int joinChatNo(ChatRoom room) {
		return sqlSession.selectOne("chatMapper.joinChatNo", room);
	}


	
	/** 내가 참여중인지 아닌지 조회
	 * @param room
	 * @return result 있으면 1 아니면 0 
	 */
	public int selectJoinCount2(ChatRoom room) {
		
		return sqlSession.selectOne("chatMapper.selectJoinCount2",room);
	}


	/** 나를 참여상태로 바꾸기
	 * @param room
	 * @return result
	 */
	public int updateMyJoin(ChatRoom room) {
		
		
		return sqlSession.update("chatMapper.updateMyJoin", room);
	}


	/** 채팅방 생성하기
	 * @param room
	 * @return result
	 */
	public int insertChatRoom(ChatRoom room) {
		
		return sqlSession.insert("chatMapper.insertChatRoom", room);
	}


	/** 채팅방 참여
	 * @param room
	 * @return result
	 */
	public int insertChatRoomJoin(ChatRoom room) {
		
		return sqlSession.insert("chatMapper.insertChatRoomJoin", room);
	}


	/** 채팅방 친구 초대
	 * @param room
	 * @return result
	 */
	public int insertFriend(ChatRoom room) {
		return sqlSession.insert("chatMapper.insertFriend" , room);
	}


	
	/** 친구 이미지 , 이름 가져오기
	 * @param room
	 * @return result
	 */
	public ChatRoom selectFriend(ChatRoom room) {
		return sqlSession.selectOne("chatMapper.selectFriend",room);
	}


	public List<ChatFriend> searchPersion(ChatFriend chat) {
		return sqlSession.selectList("chatMapper.searchPerson",chat);
	}





}
