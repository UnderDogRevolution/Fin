package com.movie.sns.post.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Movie;
import com.movie.sns.post.model.vo.Post;
import com.movie.sns.post.model.vo.PostImage;
import com.movie.sns.post.model.vo.Report;
import com.movie.sns.post.model.vo.Tag;

@Repository
public class PostDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Tag> selectTag(String tagName) {
		return sqlSession.selectList("postMapper.selectTag", tagName);
	}

	public List<Member> selectUser(String tagName) {
		return sqlSession.selectList("postMapper.selectUser", tagName);
	}

	public int insertPost(Post post) {
		return sqlSession.insert("postMapper.insertPost", post);
	}

	public int dupCheckTag(Map<String, Object> map) {
		return sqlSession.selectOne("postMapper.dupCheckTag", map);
	}

	public int insertPostTag(Map<String, Object> map) {
		return sqlSession.insert("postMapper.insertPostTag", map);
	}

	public int inserTag(Map<String, Object> map) {
		return sqlSession.insert("postMapper.insertTag", map);
	}

	public int dupCheckMovie(Movie movie) {
		return sqlSession.selectOne("postMapper.dupCheckMovie", movie);
	}
	
	public int insertMovie(Movie movie) {
		return sqlSession.insert("postMapper.insertMovie", movie);
	}

	public int insertRating(Movie movie) {
		return sqlSession.insert("postMapper.insertRating", movie);
	}

	public int insertImgLIst(List<PostImage> imgList) {
		return sqlSession.insert("postMapper.insertImgList", imgList);
	}

	public List<Post> selectPostList(int memberNo) {
		return sqlSession.selectList("postMapper.selectPostList", memberNo);
	}

	public int insertLike(Map<String, Integer> likeMap) {
		return sqlSession.insert("postMapper.insertLike", likeMap);
	}

	public int checkDupLike(Map<String, Integer> likeMap) {
		return sqlSession.selectOne("postMapper.checkDupLike", likeMap);
	}

	public int deleteLike(Map<String, Integer> likeMap) {
		return sqlSession.insert("postMapper.deleteLike", likeMap);
	}

	public int plusLike(int postNo) {
		return sqlSession.update("postMapper.plusLike", postNo);
	}

	public int minusLike(int postNo) {
		return sqlSession.update("postMapper.minusLike", postNo);
	}

	public int deletePost(int postNo) {
		return sqlSession.update("postMapper.deletePost", postNo);
	}

	public Post selectPostOne(Post post) {
		return sqlSession.selectOne("postMapper.selectPostOne", post);
	}

	public int insertReport(Report report) {
		return sqlSession.insert("postMapper.insertReport", report);
	}

	public int checkMemberNo(String memberName) {
		return sqlSession.selectOne("postMapper.checkMemberNo", memberName);
	}

	public int searchMemberNo(String memberName) {
		return sqlSession.selectOne("postMapper.searchMemberNo", memberName);
	}

	public List<Post> searchPostList(Map<String, Object> map) {
		return sqlSession.selectList("postMapper.searchPostList", map);
	}

	public List<Post> popularPostList(Map<String, Object> map) {
		return sqlSession.selectList("postMapper.popularPostList", map);
	}

	public List<Post> searchMoviePostList(Map<String, Object> map) {
		return sqlSession.selectList("postMapper.searchMoviePostList", map);
	}


}
