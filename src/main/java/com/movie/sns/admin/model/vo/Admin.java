package com.movie.sns.admin.model.vo;

public class Admin {
	
	private int memberNo;			
	private String name;		
	private String nickName;	
	private String password;		
	private String email;
	private String imgPath;
	private String imgName;
	private String enrollDt;
	private int statusCd;
	private int gradeCd;
	private String birth;
	
	public Admin() {
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public String getEnrollDt() {
		return enrollDt;
	}



	public void setEnrollDt(String enrollDt) {
		this.enrollDt = enrollDt;
	}



	public int getStatusCd() {
		return statusCd;
	}



	public void setStatusCd(int statusCd) {
		this.statusCd = statusCd;
	}



	public int getGradeCd() {
		return gradeCd;
	}



	public void setGradeCd(int gradeCd) {
		this.gradeCd = gradeCd;
	}



	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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



	@Override
	public String toString() {
		return "Admin [memberNo=" + memberNo + ", name=" + name + ", nickName=" + nickName + ", password=" + password
				+ ", email=" + email + ", imgPath=" + imgPath + ", imgName=" + imgName + ", enrollDt=" + enrollDt
				+ ", statusCd=" + statusCd + ", gradeCd=" + gradeCd + ", birth=" + birth + "]";
	}



	


	
}
