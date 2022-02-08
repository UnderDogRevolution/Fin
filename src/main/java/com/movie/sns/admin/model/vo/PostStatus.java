package com.movie.sns.admin.model.vo;

public class PostStatus {
	
	
	private int statusCd;
	private String statusNm;
	@Override
	public String toString() {
		return "PostStatus [statusCd=" + statusCd + ", statusNm=" + statusNm + "]";
	}
	public int getStatusCd() {
		return statusCd;
	}
	public void setStatusCd(int statusCd) {
		this.statusCd = statusCd;
	}
	public String getStatusNm() {
		return statusNm;
	}
	public void setStatusNm(String statusNm) {
		this.statusNm = statusNm;
	}
	
	
	
}
