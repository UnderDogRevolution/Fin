package com.movie.sns.post.model.vo;

public class Youtube {
	private int postYoutubeNo;
	private String youtubePath;
	private String videoId;
	private String thumbnail;
	private int postNo;
	public int getPostYoutubeNo() {
		return postYoutubeNo;
	}
	public void setPostYoutubeNo(int postYoutubeNo) {
		this.postYoutubeNo = postYoutubeNo;
	}
	public String getYoutubePath() {
		return youtubePath;
	}
	public void setYoutubePath(String youtubePath) {
		this.youtubePath = youtubePath;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	@Override
	public String toString() {
		return "Youtube [postYoutubeNo=" + postYoutubeNo + ", youtubePath=" + youtubePath + ", videoId=" + videoId
				+ ", thumbnail=" + thumbnail + ", postNo=" + postNo + "]";
	}
	
}
