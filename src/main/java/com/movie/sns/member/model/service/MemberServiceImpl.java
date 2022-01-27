package com.movie.sns.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movie.sns.member.model.dao.MemberDAO;
import com.movie.sns.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	// 로그인
	@Override
	public Member login(Member member) {
		
		System.out.println(member.getMemberPw());
		
		String encPw = encoder.encode(member.getMemberPw());
		
		Member loginMember = dao.login(member.getMemberEmail());
		
		/*
		if(loginMember != null && encoder.matches(member.getMemberPw(), loginMember.getMemberPw()) ) {
			
			loginMember.setMemberPw(null);
			
		}
		else {
			
			loginMember = null;
			
		}
		*/
		
		if(loginMember != null && member.getMemberPw().equals( loginMember.getMemberPw() ) ) {
			loginMember.setMemberPw(null);
		}else {
			loginMember = null;
		}
		
		
		return loginMember;
		
	}
	
	
	
	

}
