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
	
	private Image profileImage;		// 프로필 이미지
	
	private String memberStatusName;	// 회원 상태 이름
	private String memberGradeName;		// 회원 등급 이름
	
	private int violationCount;		// 경고 횟수
	private int violationNo;			// 경고 번호
	private String violationContent;	// 경고 내용
	
	// 팔로잉 리스트, 팔로워 리스트 추가 예정
	private int toUser; // 나를 팔로우한 회원번호 
	
	// 기본생성자
	public Member() {	}
	
	

	private int getViolationCount() {
		return violationCount;
	}



	private void setViolationCount(int violationCount) {
		this.violationCount = violationCount;
	}



	private int getMemberNo() {
		return memberNo;
	}

	private void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	private String getMemberName() {
		return memberName;
	}

	private void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	private String getMemberNickName() {
		return memberNickName;
	}

	private void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	private String getMemberPw() {
		return memberPw;
	}

	private void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	private String getMemberEmail() {
		return memberEmail;
	}

	private void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	private String getEnrollDate() {
		return enrollDate;
	}

	private void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	private String getModifyDate() {
		return modifyDate;
	}

	private void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	private String getMemberBirth() {
		return memberBirth;
	}

	private void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	private int getMemberStatusCode() {
		return memberStatusCode;
	}

	private void setMemberStatusCode(int memberStatusCode) {
		this.memberStatusCode = memberStatusCode;
	}

	private int getMemberGradeCode() {
		return memberGradeCode;
	}

	private void setMemberGradeCode(int memberGradeCode) {
		this.memberGradeCode = memberGradeCode;
	}

	private Image getProfileImage() {
		return profileImage;
	}

	private void setProfileImage(Image profileImage) {
		this.profileImage = profileImage;
	}

	private String getMemberStatusName() {
		return memberStatusName;
	}

	private void setMemberStatusName(String memberStatusName) {
		this.memberStatusName = memberStatusName;
	}

	private String getMemberGradeName() {
		return memberGradeName;
	}

	private void setMemberGradeName(String memberGradeName) {
		this.memberGradeName = memberGradeName;
	}

	private int getViolationNo() {
		return violationNo;
	}

	private void setViolationNo(int violationNo) {
		this.violationNo = violationNo;
	}

	private String getViolationContent() {
		return violationContent;
	}

	private void setViolationContent(String violationContent) {
		this.violationContent = violationContent;
	}

	private int getToUser() {
		return toUser;
	}

	private void setToUser(int toUser) {
		this.toUser = toUser;
	}



	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberName=" + memberName + ", memberNickName=" + memberNickName
				+ ", memberPw=" + memberPw + ", memberEmail=" + memberEmail + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", memberBirth=" + memberBirth + ", memberStatusCode="
				+ memberStatusCode + ", memberGradeCode=" + memberGradeCode + ", profileImage=" + profileImage
				+ ", memberStatusName=" + memberStatusName + ", memberGradeName=" + memberGradeName
				+ ", violationCount=" + violationCount + ", violationNo=" + violationNo + ", violationContent="
				+ violationContent + ", toUser=" + toUser + "]";
	}

	


	



	
	


}





