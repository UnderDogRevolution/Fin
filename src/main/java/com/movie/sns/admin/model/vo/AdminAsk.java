package com.movie.sns.admin.model.vo;

public class AdminAsk {
	
	private int memberNo;			//회원번호
	private String memberName;		// 이름		
	
	private int askNo;				//문의번호
	private String askTitle;		//문의제목
	private String askContent;		//문의내용
	private String askDate;			//문의작성일
	
	public AdminAsk() {}
	
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


	public int getAskNo() {
		return askNo;
	}


	public void setAskNo(int askNo) {
		this.askNo = askNo;
	}


	public String getAskTitle() {
		return askTitle;
	}


	public void setAskTitle(String askTitle) {
		this.askTitle = askTitle;
	}


	public String getAskContent() {
		return askContent;
	}


	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}


	public String getAskDate() {
		return askDate;
	}


	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}


	@Override
	public String toString() {
		return "AdminAsk [memberNo=" + memberNo + ", memberName=" + memberName + ", askNo=" + askNo + ", askTitle="
				+ askTitle + ", askContent=" + askContent + ", askDate=" + askDate + "]";
	}
	
}
