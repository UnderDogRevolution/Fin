package com.movie.sns.board1.model.dao;

import org.springframework.stereotype.Repository;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Post;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class Board1DAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public Member selectProfile(int memberNo) {

		System.out.println("====================================");
		System.out.println(memberNo);

		return sqlSession.selectOne("boardMapper.selectProfile", memberNo);

	}

	public List<Post> selectList(int memberNo) {

		return sqlSession.selectList("boardMapper.selectList", memberNo);

	}

	public List<Post> selectLike(int memberNo) {
		
		return sqlSession.selectList("boardMapper.selectLike", memberNo);
	}

	public int insertFollow(Map<String, Object> map) {
		
		return sqlSession.insert("boardMapper.insertFollow", map);
	}

	public int deleteFollow(Map<String, Object> map) {
		
		return sqlSession.delete("boardMapper.deleteFollow", map);
	}

	public int followCheck(Member member) {
		
		return sqlSession.selectOne("boardMapper.followCheck", member);
	}



}
