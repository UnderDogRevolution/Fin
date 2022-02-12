package com.movie.sns.chat.model.vo;

public class ChatFriend {

	private int toUser; // 나를 팔로우한 회원번호
	private int memberNo; // 회원번호
	private String imgPath; // 이미지 서버저장경로
	private String imgNm; // 이미지 번호
	private String memberNm; // 상대방 이름
	private String memberNickNm; // 상대방 이름
	private String memberBirth;
	private String inputResult;
	private int CNT;
	public ChatFriend() {
	}
	
	
	
	public int getCNT() {
		return CNT;
	}



	public void setCNT(int cNT) {
		CNT = cNT;
	}



	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getInputResult() {
		return inputResult;
	}

	public void setInputResult(String inputResult) {
		this.inputResult = inputResult;
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
	
	public String getMemberNickNm() {
		return memberNickNm;
	}

	public void setMemberNickNm(String memberNickNm) {
		this.memberNickNm = memberNickNm;
	}



	@Override
	public String toString() {
		return "ChatFriend [toUser=" + toUser + ", memberNo=" + memberNo + ", imgPath=" + imgPath + ", imgNm=" + imgNm
				+ ", memberNm=" + memberNm + ", memberNickNm=" + memberNickNm + ", memberBirth=" + memberBirth
				+ ", inputResult=" + inputResult + ", CNT=" + CNT + "]";
	}





	
	
}
