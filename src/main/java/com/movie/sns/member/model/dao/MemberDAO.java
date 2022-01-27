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



	/** 이메일 중복 체크
	 * @param memberEmail
	 * @return result
	 */
	public int emailDupCheck(String memberEmail) {

		return sqlSession.selectOne("memberMapper.emailDupCheck",memberEmail);
	}



	/** 닉네임 중복 체크
	 * @param memberNickName
	 * @return result
	 */
	public int nickNameDupCheck(String memberNickName) {
		return sqlSession.selectOne("memberMapper.nickNameDupCheck",memberNickName);
	}



	/** 회원 가입 수행
	 * @param member
	 * @return member
	 */
	public int signUp(Member member) {
		return sqlSession.insert("memberMapper.signUp", member);
	}
	
}
