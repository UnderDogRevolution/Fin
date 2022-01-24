package com.movie.sns.member.model.service;

import java.util.Map;

import com.movie.sns.member.model.vo.Member;

public interface MemberService2 {

	
	 
	/** 로그인
	 * @param member
	 * @return member
	 */
	Member login(Member member);
	
	/** 회원 정보 수정
	 * @param member
	 * @return result
	 */
	int updateMember(Member member);

	/** 비밀번호 변경
	 * @param map
	 * @return result
	 */
	int updatePw(Map<String, String> map);

	/** 회원 탈퇴
	 * @param memberNo
	 * @param currentPw
	 * @return result
	 */
	int secession(int memberNo, String currentPw);

}
