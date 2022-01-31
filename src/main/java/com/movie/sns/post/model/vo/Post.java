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
	
	// Movie
	private String movieNo;
	private String movieTitle;
	private String movieDate;
	private String director;
	private String poster;
	private String movieGenre;
	private String rating;
	
	// Member
	private String memberName;
	private String memberNickName;
	
	private List<PostImage> listPostImage;
	
	public String getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(String movieNo) {
		this.movieNo = movieNo;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
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
