package com.movie.sns.admin.model.vo;

public class AdminPost {
	private int postNo;
	private String memberNm;
	private String postContent;
	private int readCount;
	private int likeCount;
	private String createDt;
	private int memberNo;
	private String statusNm;
		
	
	public AdminPost() {
	}


	public String getMemberNm() {
		return memberNm;
	}


	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}


	public int getPostNo() {
		return postNo;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public String getPostContent() {
		return postContent;
	}


	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}


	public int getLikeCount() {
		return likeCount;
	}


	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}


	public String getCreateDt() {
		return createDt;
	}


	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}




	public String getStatusNm() {
		return statusNm;
	}


	public void setStatusNm(String statusNm) {
		this.statusNm = statusNm;
	}


	@Override
	public String toString() {
		return "AdminPost [postNo=" + postNo + ", memberNm=" + memberNm + ", postContent=" + postContent
				+ ", readCount=" + readCount + ", likeCount=" + likeCount + ", createDt=" + createDt + ", memberNo="
				+ memberNo + ", statusNm=" + statusNm + "]";
	}



	
	
}