package com.movie.sns.chat.model.vo;

public class ChatFriend {

	private int toUser; // 나를 팔로우한 회원번호
	private int memberNo; // 회원번호
	private String imgPath; // 이미지 서버저장경로
	private String imgNm; // 이미지 번호
	private String memberNm; // 상대방 이름
	
	public ChatFriend() {
	}

	public int getToUser() {
		return toUser;
	}

	public void setToUser(int toUser) {
		this.toUser = toUser;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgNm() {
		return imgNm;
	}

	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}

	public String getMemberNm() {
		return memberNm;
	}

	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	@Override
	public String toString() {
		return "ChatFriend [toUser=" + toUser + ", memberNo=" + memberNo + ", imgPath=" + imgPath + ", imgNm=" + imgNm
				+ ", memberNm=" + memberNm + "]";
	}






	
	
}
