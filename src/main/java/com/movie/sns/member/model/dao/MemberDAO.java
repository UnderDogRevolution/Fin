package com.movie.sns.member.model.dao;

import java.util.Map;

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



	// -----------------------------------------------------------------------------------------------------------------------------
	// memberMapper2 사용
	
	
	/** 암호화 이메일을 DB에 삽입하기
	 * @param emailMap
	 * @return result
	 */
	public int insertEncEmail(Map<String, String> emailMap) {

		return sqlSession.insert("memberMapper2.insertEncEmail", emailMap);
	}



	/** 암호화된 문자로 회원 이메일 찾기
	 * @param encEmail
	 * @return memberEmail
	 */
	public String findMemberEmail(String encEmail) {

		return sqlSession.selectOne("memberMapper2.findMemberEmail", encEmail);
	}



	/** 새로운 비밀번호 설정하기 (비밀번호 찾기)
	 * @param member
	 * @return result
	 */
	public int resetPw(Member member) {

		return sqlSession.update("memberMapper2.resetPw", member);
	}



	/** 해당 이메일의 변경 요청 모두 삭제하기(DB 기록값)
	 * @param memberEmail
	 */
	public void deleteResetLog(String memberEmail) {

		sqlSession.delete("memberMapper2.deleteResetLog", memberEmail);
	}



	
}
