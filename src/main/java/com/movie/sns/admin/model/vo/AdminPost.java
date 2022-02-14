package com.movie.sns.admin.model.vo;

public class AdminPost {
	private int postNo;
	private String memberNm;
	private String memberNick;
	private String postContent;
	private int readCount;
	private int likeCount;
	private String createDt;
	private int memberNo;
	private String statusNm;
	private String modifyDt;
	private String blind;
	private String status;
	private String searchPost;
	private String inputResult;
	private String imgPath; // 이미지경로
	private String imgNm; // 이미지네임
	private int CNT; // 신고수
	private String poster; // 영화이미지경로
	private String statusValue; // 상태값
	private String sortColumn; // 정렬할 컬럼
	private String sortMethod; // 정렬 방식
	private String youtube_path;// 유튜브 경로
	public AdminPost() {
	}
	
		
		



	public String getYoutube_path() {
		return youtube_path;
	}






	public void setYoutube_path(String youtube_path) {
		this.youtube_path = youtube_path;
	}






	public int getPostNo() {
		return postNo;
	}








	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}








	public String getMemberNm() {
		return memberNm;
	}








	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}








	public String getMemberNick() {
		return memberNick;
	}








	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
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








	public String getModifyDt() {
		return modifyDt;
	}








	public void setModifyDt(String modifyDt) {
		this.modifyDt = modifyDt;
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








	public int getCNT() {
		return CNT;
	}








	public void setCNT(int cNT) {
		CNT = cNT;
	}








	public String getPoster() {
		return poster;
	}








	public void setPoster(String poster) {
		this.poster = poster;
	}








	public String getStatusValue() {
		return statusValue;
	}








	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}








	public String getSortColumn() {
		return sortColumn;
	}








	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}








	public String getSortMethod() {
		return sortMethod;
	}








	public void setSortMethod(String sortMethod) {
		this.sortMethod = sortMethod;
	}






	@Override
	public String toString() {
		return "AdminPost [postNo=" + postNo + ", memberNm=" + memberNm + ", memberNick=" + memberNick
				+ ", postContent=" + postContent + ", readCount=" + readCount + ", likeCount=" + likeCount
				+ ", createDt=" + createDt + ", memberNo=" + memberNo + ", statusNm=" + statusNm + ", modifyDt="
				+ modifyDt + ", blind=" + blind + ", status=" + status + ", searchPost=" + searchPost + ", inputResult="
				+ inputResult + ", imgPath=" + imgPath + ", imgNm=" + imgNm + ", CNT=" + CNT + ", poster=" + poster
				+ ", statusValue=" + statusValue + ", sortColumn=" + sortColumn + ", sortMethod=" + sortMethod
				+ ", youtube_path=" + youtube_path + "]";
	}






	




	

}
