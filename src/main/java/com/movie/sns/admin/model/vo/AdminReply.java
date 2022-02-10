package com.movie.sns.admin.model.vo;

public class AdminReply {
	private int replyNo;
	private int postNo;
	private int memberNo;
	private String memberNm;
	private String replyContent;
	private int likeCount;
	private String createDt;
	private String status; // 상태넘버
	private String statusNm;
	private String blind;
	private String searchPost;
	private String inputResult; 
	public AdminReply() {
	}
	@Override
	public String toString() {
		return "AdminReply [replyNo=" + replyNo + ", postNo=" + postNo + ", memberNo=" + memberNo + ", memberNm="
				+ memberNm + ", replyContent=" + replyContent + ", likeCount=" + likeCount + ", createDt=" + createDt
				+ ", statusNm=" + statusNm + ", blind=" + blind + ", status=" + status + ", searchPost=" + searchPost
				+ ", inputResult=" + inputResult + "]";
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
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
	public String getMemberNm() {
		return memberNm;
	}
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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
	public String getStatusNm() {
		return statusNm;
	}
	public void setStatusNm(String statusNm) {
		this.statusNm = statusNm;
	}
	public String getBlind() {
		return blind;
	}
	public void setBlind(String blind) {
		this.blind = blind;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSearchPost() {
		return searchPost;
	}
	public void setSearchPost(String searchPost) {
		this.searchPost = searchPost;
	}
	public String getInputResult() {
		return inputResult;
	}
	public void setInputResult(String inputResult) {
		this.inputResult = inputResult;
	}















	
	
}
