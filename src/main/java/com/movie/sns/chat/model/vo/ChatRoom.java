package com.movie.sns.chat.model.vo;

import java.util.List;

import com.movie.sns.member.model.vo.Image;

public class ChatRoom {
	
	private List<Image> img;
	private int chatRoomNo;
	private int statusCode;
	private int memberNo;
	private String memberName;
	private int friendNo; // 친구 번호
	private String friendNm; // 친구 이름
	private String imgPath;
	private String imgNm;
	private int cnt; // 참여자 수
	private String memberBirth;
	private String inputResult;
	private int count;
	public ChatRoom() {
		// TODO Auto-generated constructor stub
	}

	

	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
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



	public int getCnt() {
		return cnt;
	}



	public void setCnt(int cnt) {
		this.cnt = cnt;
	}



	public List<Image> getImg() {
		return img;
	}



	public void setImg(List<Image> img) {
		this.img = img;
	}



	@Override
	public String toString() {
		return "ChatRoom [img=" + img + ", chatRoomNo=" + chatRoomNo + ", statusCode=" + statusCode + ", memberNo="
				+ memberNo + ", memberName=" + memberName + ", friendNo=" + friendNo + ", friendNm=" + friendNm
				+ ", imgPath=" + imgPath + ", imgNm=" + imgNm + ", cnt=" + cnt + ", memberBirth=" + memberBirth
				+ ", inputResult=" + inputResult + ", count=" + count + "]";
	}
















}
