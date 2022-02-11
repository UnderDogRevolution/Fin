package com.movie.sns.post.model.vo;

import java.util.List;

import com.movie.sns.member.model.vo.Image;

public class Post {
	private int postNo;
	private String postContent;
	private int readCount;
	private int likeCount;
	private String createDate;
	private String modifyDate;
	private int postStatusCode;
	private int memberNo;
	private int checkUsePoster; 
	
	private int checkLike;
	
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
	
	private List<Image> listProfile;
	
	private int replyCount;
	
	// Youtube
	private String youtubePath;
	private String thumbnail;
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
	public int getCheckUsePoster() {
		return checkUsePoster;
	}
	public void setCheckUsePoster(int checkUsePoster) {
		this.checkUsePoster = checkUsePoster;
	}
	public int getCheckLike() {
		return checkLike;
	}
	public void setCheckLike(int checkLike) {
		this.checkLike = checkLike;
	}
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
	public List<PostImage> getListPostImage() {
		return listPostImage;
	}
	public void setListPostImage(List<PostImage> listPostImage) {
		this.listPostImage = listPostImage;
	}
	public List<Image> getListProfile() {
		return listProfile;
	}
	public void setListProfile(List<Image> listProfile) {
		this.listProfile = listProfile;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public String getYoutubePath() {
		return youtubePath;
	}
	public void setYoutubePath(String youtubePath) {
		this.youtubePath = youtubePath;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	@Override
	public String toString() {
		return "Post [postNo=" + postNo + ", postContent=" + postContent + ", readCount=" + readCount + ", likeCount="
				+ likeCount + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", postStatusCode="
				+ postStatusCode + ", memberNo=" + memberNo + ", checkUsePoster=" + checkUsePoster + ", checkLike="
				+ checkLike + ", movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", movieDate=" + movieDate
				+ ", director=" + director + ", poster=" + poster + ", movieGenre=" + movieGenre + ", rating=" + rating
				+ ", memberName=" + memberName + ", memberNickName=" + memberNickName + ", listPostImage="
				+ listPostImage + ", listProfile=" + listProfile + ", replyCount=" + replyCount + ", youtubePath="
				+ youtubePath + ", thumbnail=" + thumbnail + "]";
	}
	
	
}