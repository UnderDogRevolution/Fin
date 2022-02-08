package com.movie.sns.admin.model.service;

import java.util.List;

import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;

public interface AdminService {
	
	// 관리자 로그인
	Admin adminLogin(Admin member);

	Pagination getPagination(int cp);

	List<Member> memberBoard(Pagination pagination);

	List<Member> selectAskList(Pagination pagination);

}
