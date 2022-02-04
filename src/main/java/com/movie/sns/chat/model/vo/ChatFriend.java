package com.movie.sns.chat.model.vo;

public class ChatFriend {

	private int follower; // 나를 팔로우한 회원번호
	private int memberNo; // 회원번호
	private int statusNo; // 상태 0 친구 x 1 친구 o
	private String imgPath; // 이미지 서버저장경로
	private String imgNm; // 이미지 번호
	private String memberNm; // 상대방 이름
	
	public ChatFriend() {
	}




	public int getFollower() {
		return follower;
	}




	public void setFollower(int follower) {
		this.follower = follower;
	}




	public int getMemberNo() {
		return memberNo;
	}




	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}




	public int getStatusNo() {
		return statusNo;
	}




	public void setStatusNo(int statusNo) {
		this.statusNo = statusNo;
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
		return "ChatFriend [follower=" + follower + ", memberNo=" + memberNo + ", statusNo=" + statusNo + ", imgPath="
				+ imgPath + ", imgNm=" + imgNm + ", memberNm=" + memberNm + "]";
	}




	
	
}
