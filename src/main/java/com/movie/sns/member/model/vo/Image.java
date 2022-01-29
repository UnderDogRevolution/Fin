package com.movie.sns.member.model.vo;

public class Image {
	private int imgNo;	//이미지 번호
	private String imgPath; //이미지 경로
	private String imgName;	//이미지 이름
	private String imgOriginal;	//이미지 원본
	private int imgLevel;	//이미지 레벨
	private int memberNo; //사용자 번호
	
	public Image() {}

	public int getImgNo() {
		return imgNo;
	}

	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgOriginal() {
		return imgOriginal;
	}

	public void setImgOriginal(String imgOriginal) {
		this.imgOriginal = imgOriginal;
	}

	public int getImgLevel() {
		return imgLevel;
	}

	public void setImgLevel(int imgLevel) {
		this.imgLevel = imgLevel;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Image [imgNo=" + imgNo + ", imgPath=" + imgPath + ", imgName=" + imgName + ", imgOriginal="
				+ imgOriginal + ", imgLevel=" + imgLevel + ", memberNo=" + memberNo + "]";
	}

	
}
