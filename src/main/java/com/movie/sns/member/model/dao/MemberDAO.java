package com.movie.sns.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.member.model.vo.Member;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	
	
	/** 로그인
	 * @param memberEmail
	 * @return member
	 */
	public Member login(String memberEmail) {
		
		return sqlSession.selectOne("memberMapper.login", memberEmail);
		
	}
	
	
}
