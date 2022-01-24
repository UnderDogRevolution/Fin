package com.movie.sns.member.model.vo;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;


public class UserImgsVO {
	
	private int userImgNo;
	private int userNo;
	private String profileName;
	private long profileSize;
	private String profileContentType;
	private byte[] profileData;
	
	private MultipartFile file;
	
	// 기본생성자
	public UserImgsVO() {	}

	public int getUserImgNo() {
		return userImgNo;
	}

	public void setUserImgNo(int userImgNo) {
		this.userImgNo = userImgNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public long getProfileSize() {
		return profileSize;
	}

	public void setProfileSize(long profileSize) {
		this.profileSize = profileSize;
	}

	public String getProfileContentType() {
		return profileContentType;
	}

	public void setProfileContentType(String profileContentType) {
		this.profileContentType = profileContentType;
	}

	public byte[] getProfileData() {
		return profileData;
	}

	public void setProfileData(byte[] profileData) {
		this.profileData = profileData;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "UserImgsVO [userImgNo=" + userImgNo + ", userNo=" + userNo + ", profileName=" + profileName
				+ ", profileSize=" + profileSize + ", profileContentType=" + profileContentType + ", profileData="
				+ Arrays.toString(profileData) + ", file=" + file + "]";
	}
	
	
}