package com.movie.sns.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.member.model.dao.MemberDAO;
import com.movie.sns.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	
	// 로그인
	@Override
	public Member login(Member member) {

//		return dao.login(member);
		
		return null;
	}
	
	
	
	

}
