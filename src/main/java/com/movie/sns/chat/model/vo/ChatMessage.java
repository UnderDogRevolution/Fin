package com.movie.sns.chat.model.vo;


public class ChatMessage {
	private int chatMessageNo;
	private String message;
	private String createDate;
	private int chatRoomNo;
	private int memberNo;
	private int targetNo;
	private String imgPath;
	private String imgName;
	private int type;
	private String path; // 이미지경로저장
	private String memberName;
	private String memberId;
	
	
	public ChatMessage() {
	}


	public int getChatMessageNo() {
		return chatMessageNo;
	}


	public void setChatMessageNo(int chatMessageNo) {
		this.chatMessageNo = chatMessageNo;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public int getChatRoomNo() {
		return chatRoomNo;
	}


	public void setChatRoomNo(int chatRoomNo) {
		this.chatRoomNo = chatRoomNo;
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


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public int getTargetNo() {
		return targetNo;
	}


	public void setTargetNo(int targetNo) {
		this.targetNo = targetNo;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	@Override
	public String toString() {
		return "ChatMessage [chatMessageNo=" + chatMessageNo + ", message=" + message + ", createDate=" + createDate
				+ ", chatRoomNo=" + chatRoomNo + ", memberNo=" + memberNo + ", targetNo=" + targetNo + ", imgPath="
				+ imgPath + ", imgName=" + imgName + ", type=" + type + ", path=" + path + ", memberName=" + memberName
				+ ", memberId=" + memberId + "]";
	}





	
	


	
}
