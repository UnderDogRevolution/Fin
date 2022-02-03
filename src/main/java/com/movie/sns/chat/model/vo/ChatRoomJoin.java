package com.movie.sns.chat.model.vo;

public class ChatRoomJoin {
	private int memberNo;
	private int chatRoomNo;
	private int statusCode;
	public ChatRoomJoin() {
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getChatRoomNo() {
		return chatRoomNo;
	}

	public void setChatRoomNo(int chatRoomNo) {
		this.chatRoomNo = chatRoomNo;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ChatRoomJoin [memberNo=" + memberNo + ", chatRoomNo=" + chatRoomNo + ", statusCode=" + statusCode + "]";
	}

}
