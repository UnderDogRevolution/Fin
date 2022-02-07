package com.movie.sns.post.model.vo;

public class Movie {
	private String movieNo;
	private String movieTitle;
	private String movieDate;
	private String director;
	private String poster;
	private String movieGenre;
	
	private String rating;
	private int postNo;
	private int memberNo;
	
	private int AVG;
	private int ratingCount;
	
	
	public int getRatingCount() {
		return ratingCount;
	}
	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}
	public int getAVG() {
		return AVG;
	}
	public void setAVG(int aVG) {
		AVG = aVG;
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
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "Movie [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", movieDate=" + movieDate + ", director="
				+ director + ", poster=" + poster + ", movieGenre=" + movieGenre + ", rating=" + rating + ", postNo="
				+ postNo + ", memberNo=" + memberNo + ", AVG=" + AVG + ", getAVG()=" + getAVG() + ", getMovieNo()="
				+ getMovieNo() + ", getMovieTitle()=" + getMovieTitle() + ", getMovieDate()=" + getMovieDate()
				+ ", getDirector()=" + getDirector() + ", getPoster()=" + getPoster() + ", getMovieGenre()="
				+ getMovieGenre() + ", getRating()=" + getRating() + ", getPostNo()=" + getPostNo() + ", getMemberNo()="
				+ getMemberNo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
