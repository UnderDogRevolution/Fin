package com.movie.sns.admin.model.service;

import java.util.List;

import com.movie.sns.admin.model.vo.AdminMemberSearch;
import com.movie.sns.admin.model.vo.MemberStatus;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;

public interface AdminMemberService {

	/** 모든 회원 수 + 페이지
	 * @param cp
	 * @return pagination
	 */
	Pagination getPagination(int cp);

	/** 회원 리스트 조회하기
	 * @param pagination
	 * @return
	 */
	List<Member> selectMemberList(Pagination pagination);

	/** 회원 정보 상세 조회하기
	 * @param memberNo
	 * @return
	 */
	Member selectMemberDetail(int memberNo);

	/** 회원 상태 정보 얻어오기
	 * @return
	 */
	List<MemberStatus> selectStatus();

	/** 검색을 만족하는 회원 수 + 페이지
	 * @param cp
	 * @param search
	 * @return
	 */
	Pagination getPagination(int cp, AdminMemberSearch search);

	/** 검색 조건을 만족하는 회원 리스트
	 * @param pagination
	 * @param search
	 * @return memberList
	 */
	List<Member> selectMemberList(Pagination pagination, AdminMemberSearch search);

	/** 회원 상태 변경하기
	 * @param member
	 * @return result
	 */
	int changeStatus(Member member);

	
	
	

}
