package com.movie.sns.post.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.member.model.vo.Member;
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
	
	
	
}
