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







	public Image getProfileImage() {
		return profileImage;
	}







	public void setProfileImage(Image profileImage) {
		this.profileImage = profileImage;
	}







	public String getMemberStatusName() {
		return memberStatusName;
	}







	public void setMemberStatusName(String memberStatusName) {
		this.memberStatusName = memberStatusName;
	}







	public String getMemberGradeName() {
		return memberGradeName;
	}







	public void setMemberGradeName(String memberGradeName) {
		this.memberGradeName = memberGradeName;
	}







	public int getViolationCount() {
		return violationCount;
	}







	public void setViolationCount(int violationCount) {
		this.violationCount = violationCount;
	}







	public int getViolationNo() {
		return violationNo;
	}







	public void setViolationNo(int violationNo) {
		this.violationNo = violationNo;
	}







	public String getViolationContent() {
		return violationContent;
	}







	public void setViolationContent(String violationContent) {
		this.violationContent = violationContent;
	}







	public int getToUser() {
		return toUser;
	}







	public void setToUser(int toUser) {
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





