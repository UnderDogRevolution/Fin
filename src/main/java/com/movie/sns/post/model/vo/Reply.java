package com.movie.sns.post.model.vo;

public class Reply {
	private int replyNo;
	private String replyContent;
	private String replyCreateDate;
	private int parentReply;
	private int likeCount;
	private int postNo;
	private int memberNo;
	private int replyStatusCode;
	private String replyStatusName;
	
	private String memberName;
	
	
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyCreateDate() {
		return replyCreateDate;
	}
	public void setReplyCreateDate(String replyCreateDate) {
		this.replyCreateDate = replyCreateDate;
	}
	public int getParentReply() {
		return parentReply;
	}
	public void setParentReply(int parentReply) {
		this.parentReply = parentReply;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getReplyStatusCode() {
		return replyStatusCode;
	}
	public void setReplyStatusCode(int replyStatusCode) {
		this.replyStatusCode = replyStatusCode;
	}
	public String getReplyStatusName() {
		return replyStatusName;
	}
	public void setReplyStatusName(String replyStatusName) {
		this.replyStatusName = replyStatusName;
	}
	
	
}
