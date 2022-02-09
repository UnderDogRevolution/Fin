package com.movie.sns.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.admin.model.dao.AdminMemberDAO;
import com.movie.sns.admin.model.vo.MemberStatus;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;

@Service
public class AdminMemberServiceImpl implements AdminMemberService{

	
	@Autowired
	private AdminMemberDAO dao;

	// 페이지내이션
	@Override
	public Pagination getPagination(int cp) {
		
		int listCount = dao.getListCount(); 
		
		return new Pagination(listCount, cp);
	}

	// 회원 리스트 조회
	@Override
	public List<Member> selectMemberList(Pagination pagination) {
		
		return dao.selectMemberList(pagination);
	}

	// 회원 정보 상세 조회
	@Override
	public Member selectMemberDetail(int memberNo) {

		return dao.selectMemberDetail(memberNo);
	}

	@Override
	public List<MemberStatus> selectStatus() {
		return dao.selectStatus();
	}


	
	
	
}
