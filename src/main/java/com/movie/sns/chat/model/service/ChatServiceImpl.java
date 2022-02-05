package com.movie.sns.chat.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.chat.model.dao.ChatDAO;
import com.movie.sns.chat.model.vo.ChatFriend;
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

	// 채팅상태변경
	@Override
	public int updateJoinUp(ChatMessage cm) {
		int result = 0;
		result = dao.selectFriendJoin(cm);
		System.out.println("상대방이 미 참여중 인경우 0" + result);
		if (result == 0) {
			result = dao.updateJoinUp(cm);
			if (result > 0) {
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

	/**
	 * 팔로우 인원 조회 return List
	 */
	@Override
	public List<ChatFriend> searchFollower(int memberNo) {

		return dao.searchFollower(memberNo);
	}

	/**채팅방 존재여부 확인 있으면 1 아니면 0
	 * 있을경우 result = -1 로 return 아니면 업데이트 후 1 return
	 * return result
	 */
	@Override
	public int goChatting(ChatRoom room) {
		int result = 0;

		result = dao.searchChatRoomJoin(room);
		if (result > 0) { // 채팅방이 존재할 경우
			// 방번호를 얻어와 두사람 상태가 참여중인지 조회
			result = dao.joinChatNo(room);
			System.out.println("방번호 결과값" + result);
			
					room.setChatRoomNo(result);// 조회 성공
					room = dao.selectFriend(room); // 친구 이미지, 이름 가져올려면 세팅해야됨
			if (result > 0) { // 조회값이 0보다 클 경우 방번호를 얻어옴
					result = dao.selectJoinCount2(room); // 내가 참여중인지 아닌지 확인하기
					// 내가 참여중인경우 1 아닌경우 0
					System.out.println("방번호 조회 값까지 넘어옴" + result);
					if(result > 0) {// 내가 참여중이지 않은경우 일단 채팅방이 있으니 상대방 업데이트 할 필요가 없다.
									// 왜? 메세지보내면 자동으로 상대방 참여상태를 update되게 만들었기 때문에
									// 내가 참여중인 경우 아무것도 할 필요가 없음 js에 chatRoomNo만 보내면 될 듯.
						result = -1; // result가 1일시에 요소가 생성 될 수 있게 끔 -1로 구분짓는다.
					System.out.println("내가 참여중인경우 -1" + result);
					}else {// 내가참여중이지않은경우 나를 참여중으로 바꾼다
						result = dao.updateMyJoin(room);
						System.out.println("참여중으로 바꿨다" + result);
						System.out.println("세팅되었는지 조회" + room);
					}
			}

		} else { // 채팅방이 존재하지 않을 경우
			result = dao.insertChatRoom(room);// 채팅방 생성 후 그 채팅방 안에 참여시키기 currval사용
				if(result > 0) {
					result = dao.insertChatRoomJoin(room);
					System.out.println("채팅방 생성 후 참가까지 성공 " + result);
					if(result > 0) { // memberNo로 join 성공 시 상대방도 초대
						result = dao.insertFriend(room);
						if(result > 0) {
							result = dao.joinChatNo(room);
							System.out.println("방번호 결과값" + result);
							
							room.setChatRoomNo(result);// 조회 성공
							room = dao.selectFriend(room);
						}
					}
				}
		}

		return result;
	}

	

}
