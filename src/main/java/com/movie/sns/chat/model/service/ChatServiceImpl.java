package com.movie.sns.chat.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.chat.model.dao.ChatDAO;
import com.movie.sns.chat.model.vo.ChatMessage;
import com.movie.sns.chat.model.vo.ChatRoom;
import com.movie.sns.chat.model.vo.ChatRoomJoin;
import com.movie.sns.common.Util;
import com.movie.sns.member.model.vo.Member;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatDAO dao;

	// 채팅 리스트 조회
	@Override
	public List<ChatRoom> chatRoomList(int memberNo) {

		return dao.chatRoomList(memberNo);
	}

	/**
	 * 채팅방안에있는 사람 조회 return member
	 */
	@Override
	public Member searchMember(int friendNo) {

		return dao.searchMember(friendNo);
	}

	/**
	 * 채팅방 메세지조회 return message
	 */
	@Override
	public List<ChatMessage> searchMessage(String chatNo) {

		return dao.searchMessage(chatNo);
	}

	/**
	 * 채팅 메세지 삽입 개행문자 처리
	 */
	@Override
	public int insertMessage(ChatMessage cm) {
		int result = 0;
		String message = cm.getMessage();
		System.out.println(message);
		if (cm.getType() == 1) {
			result = dao.insertMessage(cm);
		} else {

			cm.setMessage(Util.XSS(cm.getMessage()));
			cm.setMessage(Util.changeNewLine(cm.getMessage()));
			result = dao.insertMessage(cm);
		}

		/*
		 * if(result > 0) {// 완료시 상대방이 참여중인지 조회 result =dao.selectFriendJoin(cm);
		 * 
		 * System.out.println(result);
		 * 
		 * if(result == 0) { // 상대방이 채팅 참여중이다 1인경우 참여중 아닌경우 미참여중 result =
		 * dao.updateJoinUp(cm); } }
		 */

		return result;
	}

	/**
	 * 채팅방 나가기 return result 결과값 2 아니면 1
	 */
	@Override
	public int deleteChat(ChatRoomJoin join) {
		int result = dao.selectJoinCount(join); // 참여자 수 조회
		System.out.println("채팅방 결과값" + result);

		if (result > 1) { // 결과 값이 2 인경우 -- 두명다 참여중
			result = dao.updateJoin(join);

		} else {// 결과 값이 1인경우 -- 한명만 참여중이므로 채팅방 전체 삭제
			result = dao.deleteChatRoom(join);
		}
		return result;
	}

	@Override
	public int updateJoinUp(ChatMessage cm) {
			int result = 0;
			 result = dao.selectFriendJoin(cm);
			System.out.println("상대방이 미 참여중 인경우 0" +result);
			if(result == 0) {
				result = dao.updateJoinUp(cm);
					if(result > 0) {
						result = 2;
						
					}
			}
			/*
			 * if (result == 0) { // 상대방이 채팅 참여중이다 1인경우 참여중 아닌경우 미참여중 result =
			 * dao.updateJoinUp(cm); }
			 */
			System.out.println("결과 값 구분 참여 중인 경우 1 상태 업뎃시2" + result);
		return result;
	}

}
