package com.movie.sns.alram.model.vo;

public class Alram {
	
	// 댓글 대댓글 쓴 , 댓글 대댓글 게시글 좋아요 누른, 날 친구한, 날 태그한 사람 넘버
	int alramtNo;
	
	int alramTakeMemberNo; // 알람을 받을 회원번호
	int alramContent; // 알람을 받을 내용
	int alramUrl;
	
	int postNo;
	
//	
//	int postMemberNo; 					// 게시글을 작성한 회원 넘버
//	
//	int postNo;		  					// 작성한 곳의 게시글 넘버
//	int replyWriteMemberNo;	 			// 댓글 쓴사람 회원넘버
//	int replyParentWriteMemberWriteNo;	// 대댓글 쓴 사람 회원 넘버
//					
//	int replyLikeMemberNo;				// 댓글 좋아요 한 사람 회원 넘버
//	int replyParentLikeMemberNo;		// 대댓글 좋아요 한 사람 회원넘버
//	int postLikeMemberNo;				// 게시글 좋아요 한 사람 회원넘버
//	int friendConnectMemberNo;			// 친구 맺은 사람 멤버 넘버
//	int TagMemberNo;					// 태그한 새끼 넘버
//	int chatMessage;					// 채팅메세지
//	
//	// 친구 태그 채팅메세지
//	
//	int alertCheck;		// 알림 확인했는지
	
	public Alram() {
		// TODO Auto-generated constructor stub
	}

	public int getAlramtNo() {
		return alramtNo;
	}

	public void setAlramtNo(int alramtNo) {
		this.alramtNo = alramtNo;
	}

	public int getAlramTakeMemberNo() {
		return alramTakeMemberNo;
	}

	public void setAlramTakeMemberNo(int alramTakeMemberNo) {
		this.alramTakeMemberNo = alramTakeMemberNo;
	}

	public int getAlramContent() {
		return alramContent;
	}

	public void setAlramContent(int alramContent) {
		this.alramContent = alramContent;
	}

	public int getAlramUrl() {
		return alramUrl;
	}

	public void setAlramUrl(int alramUrl) {
		this.alramUrl = alramUrl;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	@Override
	public String toString() {
		return "Alram [alramtNo=" + alramtNo + ", alramTakeMemberNo=" + alramTakeMemberNo + ", alramContent="
				+ alramContent + ", alramUrl=" + alramUrl + ", postNo=" + postNo + "]";
	}

	
	
	
	
	
	
}
