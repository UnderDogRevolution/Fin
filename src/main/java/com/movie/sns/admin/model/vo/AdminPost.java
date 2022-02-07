package com.movie.sns.admin.model.vo;

public class AdminPost {
	private int postNo;
	private String postContent;
	private int readCount;
	private int likeCount;
	private String createDate;
	private String modifyDate;
	private int postStatusCode;
	private int memberNo;
	private int checkUsePoster; 
	
	private int checkLike;

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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getPostStatusCode() {
		return postStatusCode;
	}

	public void setPostStatusCode(int postStatusCode) {
		this.postStatusCode = postStatusCode;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getCheckUsePoster() {
		return checkUsePoster;
	}

	public void setCheckUsePoster(int checkUsePoster) {
		this.checkUsePoster = checkUsePoster;
	}

	public int getCheckLike() {
		return checkLike;
	}

	public void setCheckLike(int checkLike) {
		this.checkLike = checkLike;
	}

	@Override
	public String toString() {
		return "AdminPost [postNo=" + postNo + ", postContent=" + postContent + ", readCount=" + readCount
				+ ", likeCount=" + likeCount + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", postStatusCode=" + postStatusCode + ", memberNo=" + memberNo + ", checkUsePoster=" + checkUsePoster
				+ ", checkLike=" + checkLike + "]";
	}
	
	
}
