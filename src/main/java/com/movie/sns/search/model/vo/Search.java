package com.movie.sns.search.model.vo;

public class Search {
	private int memberNo;
	private String memberNm;
	private String memberNick;
	private String memberEmail;
	private String enrollDt;
	private String birth;
	private String imgPath;
	private String imgNm;
	private String search;
	private String CNT;
	public Search() {
		// TODO Auto-generated constructor stub
	}

	



	@Override
	public String toString() {
		return "Search [memberNo=" + memberNo + ", memberNm=" + memberNm + ", memberNick=" + memberNick
				+ ", memberEmail=" + memberEmail + ", enrollDt=" + enrollDt + ", birth=" + birth + ", imgPath="
				+ imgPath + ", imgNm=" + imgNm + ", search=" + search + ", CNT=" + CNT + "]";
	}










	public String getCNT() {
		return CNT;
	}




	public void setCNT(String cNT) {
		CNT = cNT;
	}








	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getEnrollDt() {
		return enrollDt;
	}

	public void setEnrollDt(String enrollDt) {
		this.enrollDt = enrollDt;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
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





	public String getSearch() {
		return search;
	}





	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
