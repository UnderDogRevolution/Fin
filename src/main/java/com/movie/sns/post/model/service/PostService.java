package com.movie.sns.post.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Movie;
import com.movie.sns.post.model.vo.Pagination;
import com.movie.sns.post.model.vo.Post;
import com.movie.sns.post.model.vo.Report;
import com.movie.sns.post.model.vo.Tag;

public interface PostService {

	List<Tag> selectTag(String tagName);

	List<Member> selectUser(String tagName);

	Map<String, Object> insertPost(Map<String, Object> postVO, List<MultipartFile> fileList, String webPath, String serverPath);

	List<Post> selectPostList(Map<String, Object> map, Pagination pagination);

	int insertLike(int postNo, int memberNo);

	int deleteLike(int postNo, int memberNo);

	int deletePost(int postNo);

	Post selectPostOne(Post post);

	int insertReport(Report report);

	int searchMemberNo(String memberName);

	List<Post> searchPostList(Map<String, Object> map, Pagination pagination);

	List<Post> popularPostList(Map<String, Object> map, Pagination pagination);

	List<Post> searchMoviePostList(Map<String, Object> map, Pagination pagination);

	List<Movie> rankMovie();

	Pagination getPagination(int cp);


}
