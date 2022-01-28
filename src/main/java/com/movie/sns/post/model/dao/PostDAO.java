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
		// TODO Auto-generated method stub
		return sqlSession.insert("postMapper.insertImgList", imgList);
	}


}
