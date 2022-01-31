package com.movie.sns.member.model.service;

import javax.servlet.http.HttpServletRequest;

import com.movie.sns.member.model.vo.Member;

public interface MemberService {

	
	 
	/** 로그인
	 * @param member
	 * @return member
	 */
	Member login(Member member);

	
	/** 이메일 중복 체크
	 * @param memberEmail
	 * @return result
	 */
	int emailDupCheck(String memberEmail);


	/** 닉네임 중복 체크
	 * @param memberNickName
	 * @return result
	 */
	int nickNameDupCheck(String memberNickName);


	/** 회원 가입 수행
	 * @param member
	 * @return member
	 */
	int signUp(Member member);


	/** 입력받은 이메일을 암호화해서 DB에 삽입하기
	 * @param memberEmail
	 * @param req 
	 * @return result
	 */
	int insertEncEmail(String memberEmail, HttpServletRequest req);


	/** 비밀번호 재설정하기
	 * @param encEmail
	 * @param newPw
	 * @return result
	 */
	int resetPw(String encEmail, String newPw);
	
	
	

}
