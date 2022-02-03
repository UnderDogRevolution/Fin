package com.movie.sns.member.model.vo;

public class MemberAuth {
	
	private int authNumber;		// 인증 순번(식별용)
	private String memberEmail;		// 가입 이메일
	private String authCode;		// 인증코드
	private String createDate;		// 인증코드 생성 시간 
	private String endDate;			// 인증코드 만료 시간(5분)
	
	public MemberAuth() {
		// TODO Auto-generated constructor stub
	}

	public int getAuthNumber() {
		return authNumber;
	}

	public void setAuthNumber(int authNumber) {
		this.authNumber = authNumber;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "MemberAuth [authNumber=" + authNumber + ", memberEmail=" + memberEmail + ", authCode=" + authCode
				+ ", createDate=" + createDate + ", endDate=" + endDate + "]";
	}

	
}
