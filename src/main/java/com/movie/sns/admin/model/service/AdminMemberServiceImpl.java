package com.movie.sns.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.admin.model.dao.AdminMemberDAO;
import com.movie.sns.admin.model.vo.AdminMemberSearch;
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

	// 검색 조건을 만족하는 페이지내이션
	@Override
	public Pagination getPagination(int cp, AdminMemberSearch search) {
		
		int searchListCount = dao.getSearchListCount(search);
		
		return new Pagination(searchListCount, cp);
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

	// 회원 상태 조회
	@Override
	public List<MemberStatus> selectStatus() {
		return dao.selectStatus();
	}

	// 검색 조건 만족하는 회원 리스트
	@Override
	public List<Member> selectMemberList(Pagination pagination, AdminMemberSearch search) {
		return dao.selectMemberList(pagination,search);
	}

	// 회원의 상태 변경
	@Override
	public int changeStatus(Member member) {
		return dao.changeStatus(member);
	}
	
	// 회원 상태 일괄 변경
	@Override
	public int multiChangeStatus(int[] checkedMemberNo, int statusValue) {
		
		int result = 0;
		
		if(statusValue == 202) {
			
			result = dao.multiChangeStatus(checkedMemberNo);
			
		}else if(statusValue == 200) {
			
			result = dao.multiChangeStatus2(checkedMemberNo);
			
		}else if(statusValue == 201) {
			
			result = dao.multiChangeStatus3(checkedMemberNo);
			
		}
		
		return result;
	}

	
	
	
	
	
}
