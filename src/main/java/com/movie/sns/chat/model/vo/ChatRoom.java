package com.movie.sns.chat.model.vo;

public class ChatRoom {
	private int chatRoomNo;
	private int statusCode;
	private int memberNo;
	private String memberName;
	private int friendNo; // 친구 번호
	private String friendNm; // 친구 이름
	 
	public ChatRoom() {
		// TODO Auto-generated constructor stub
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

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getFriendNo() {
		return friendNo;
	}

	public void setFriendNo(int friendNo) {
		this.friendNo = friendNo;
	}

	public String getFriendNm() {
		return friendNm;
	}

	public void setFriendNm(String friendNm) {
		this.friendNm = friendNm;
	}

	@Override
	public String toString() {
		return "ChatRoom [chatRoomNo=" + chatRoomNo + ", statusCode=" + statusCode + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + ", friendNo=" + friendNo + ", friendNm=" + friendNm + "]";
	}
	
	
}
