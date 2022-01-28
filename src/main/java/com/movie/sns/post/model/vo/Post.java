package com.movie.sns.post.model.vo;

import java.util.List;

public class Post {
	private int postNo;
	private String postContent;
	private int readCount;
	private int likeCount;
	private String createDate;
	private String modifyDate;
	private int postStatusCode;
	private int memberNo;
	
	private List<String> tagArr;
	
	public List<String> getTagArr() {
		return tagArr;
	}
	public void setTagArr(List<String> tagArr) {
		this.tagArr = tagArr;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getPostStatusCode() {
		return postStatusCode;
	}
	public void setPostStatusCode(int postStatusCode) {
		this.postStatusCode = postStatusCode;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	
}
