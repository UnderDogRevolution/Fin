package com.movie.sns.admin.model.vo;

public class MemberStatus {

	private int statusCode;	//	회원 상태 코드
	private String statusName;	//	회원 상태 이름
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "MemberStatus [statusCode=" + statusCode + ", statusName=" + statusName + "]";
	}
	
}
