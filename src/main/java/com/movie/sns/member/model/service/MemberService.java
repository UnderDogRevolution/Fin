package com.movie.sns.member.model.service;

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
	
	
	

}
