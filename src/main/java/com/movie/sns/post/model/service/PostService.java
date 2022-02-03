package com.movie.sns.post.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Movie;
import com.movie.sns.post.model.vo.Post;
import com.movie.sns.post.model.vo.Tag;

public interface PostService {

	List<Tag> selectTag(String tagName);

	List<Member> selectUser(String tagName);

	int insertPost(Map<String, Object> postVO, List<MultipartFile> fileList, String webPath, String serverPath);

	List<Post> selectPostList(int memberNo);

	int insertLike(int postNo, int memberNo);

	int deleteLike(int postNo, int memberNo);


}
