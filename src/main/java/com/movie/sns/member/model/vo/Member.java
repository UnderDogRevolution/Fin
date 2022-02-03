package com.movie.sns.member.model.vo;

public class Member {

	
	private int memberNo;			// 회원번호
	private String memberName;		// 이름
	private String memberNickName;	// 닉네임
	private String memberPw;		// 비밀번호
	private String memberEmail;		// 이메일
	private String enrollDate;		// 가입일
	private String modifyDate;		// 수정일
	private String memberBirth;		// 생일

	private int memberStatusCode;	// 회원상태
	private int memberGradeCode;	// 회원등급
	
	
	// 기본생성자
	public Member() {	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberNickName() {
		return memberNickName;
	}


	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}


	public String getMemberPw() {
		return memberPw;
	}


	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}


	public String getModifyDate() {
		return modifyDate;
	}


	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}


	public String getMemberBirth() {
		return memberBirth;
	}


	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}


	public int getMemberStatusCode() {
		return memberStatusCode;
	}


	public void setMemberStatusCode(int memberStatusCode) {
		this.memberStatusCode = memberStatusCode;
	}


	public int getMemberGradeCode() {
		return memberGradeCode;
	}


	public void setMemberGradeCode(int memberGradeCode) {
		this.memberGradeCode = memberGradeCode;
	}


	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberName=" + memberName + ", memberNickName=" + memberNickName
				+ ", memberPw=" + memberPw + ", memberEmail=" + memberEmail + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", memberBirth=" + memberBirth + ", memberStatusCode="
				+ memberStatusCode + ", memberGradeCode=" + memberGradeCode + "]";
	}


}





