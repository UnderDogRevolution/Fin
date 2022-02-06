package com.movie.sns.post.model.vo;

public class Report {
	private int reportNo;
	private int memberNo;
	private String reportContent;
	private String createDate;
	private int reportTypeNo;
	private int targetPK;
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
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getReportTypeNo() {
		return reportTypeNo;
	}
	public void setReportTypeNo(int reportTypeNo) {
		this.reportTypeNo = reportTypeNo;
	}
	public int getTargetPK() {
		return targetPK;
	}
	public void setTargetPK(int targetPK) {
		this.targetPK = targetPK;
	}
	
	
}
