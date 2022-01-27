package com.movie.sns.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		
		String encPw = encoder.encode(member.getMemberPw());
		
		Member loginMember = dao.login(member.getMemberEmail());
		
		
		if(loginMember != null && encoder.matches(member.getMemberPw(), loginMember.getMemberPw()) ) {
			
			loginMember.setMemberPw(null);
			
		}
		else {
			
			loginMember = null;
			
		}
		
		/*
		if(loginMember != null && member.getMemberPw().equals( loginMember.getMemberPw() ) ) {
			loginMember.setMemberPw(null);
		}else {
			loginMember = null;
		}
		*/
		
		return loginMember;
		
	}


	// 이메일 중복 체크
	@Override
	public int emailDupCheck(String memberEmail) {
		return dao.emailDupCheck(memberEmail);
	}


	// 닉네임 중복 체크
	@Override
	public int nickNameDupCheck(String memberNickName) {
		return dao.nickNameDupCheck(memberNickName);
	}


	@Override
	@Transactional
	public int signUp(Member member) {
		
		// 비밀번호 암호화
		String encPw = encoder.encode(member.getMemberPw());
		// 암호화 비밀번호 세팅
		member.setMemberPw(encPw);
		
		return dao.signUp(member);
	}
	
	
	
	
	
	
	
	

}
