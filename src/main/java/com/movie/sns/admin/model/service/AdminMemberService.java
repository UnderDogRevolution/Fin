package com.movie.sns.admin.model.service;

import java.util.List;

import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;

public interface AdminMemberService {

	/** 모든 회원 수 + 페이지
	 * @param cp
	 * @return pagination
	 */
	Pagination getPagination(int cp);

	List<Member> selectMemberList(Pagination pagination);

	
	
	

}
