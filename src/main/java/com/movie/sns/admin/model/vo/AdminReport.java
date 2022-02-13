package com.movie.sns.admin.model.vo;

public class AdminReport {
	private int reportNo;
	private int memberNo;
	private int postNo;
	private String memberNm;
	private String memberNick;
	private String reportContent;
	private String createDt;
	private int typeNo; // 0 게시글 1 댓글
	private String typeNm; // 0 게시글 1 댓글
	private String searchPost;
	private String inputResult; 
	public AdminReport() {
	
	
	}
	
	 






	@Override
	public String toString() {
		return "AdminReport [reportNo=" + reportNo + ", memberNo=" + memberNo + ", postNo=" + postNo + ", memberNm="
				+ memberNm + ", memberNick=" + memberNick + ", reportContent=" + reportContent + ", createDt="
				+ createDt + ", typeNo=" + typeNo + ", typeNm=" + typeNm + ", searchPost=" + searchPost
				+ ", inputResult=" + inputResult + "]";
	}








	public void setTypeNm(String typeNm) {
		this.typeNm = typeNm;
	}








	public int getReportNo() {
		return reportNo;
	}


	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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


	public String getReportContent() {
		return reportContent;
	}


	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}


	public String getCreateDt() {
		return createDt;
	}


	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}


	public int getTypeNo() {
		return typeNo;
	}


	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
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
