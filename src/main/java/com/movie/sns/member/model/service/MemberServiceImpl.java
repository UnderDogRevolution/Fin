package com.movie.sns.member.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.sns.member.controller.EmailController;
import com.movie.sns.member.model.dao.MemberDAO;
import com.movie.sns.member.model.vo.Member;
import com.movie.sns.member.model.vo.MemberAuth;

/**
 * @author ASUS
 *
 */
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	// 이메일 전송용 컨트롤러
	@Autowired
	private EmailController emailCtrl;
	
	
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


	// 회원 가입
	@Override
	@Transactional
	public int signUp(Member member) {
		
		// 비밀번호 암호화
		String encPw = encoder.encode(member.getMemberPw());
		// 암호화 비밀번호 세팅
		member.setMemberPw(encPw);
		
		return dao.signUp(member);
	}


	
	// 암호화 이메일 삽입
	@Override
	@Transactional
	public int insertEncEmail(String memberEmail, HttpServletRequest req) {
		
		String encEmail = encoder.encode(memberEmail);
		
		System.out.println(encEmail);
		
		Map<String, String> emailMap = new HashMap<String, String>();
		
		emailMap.put("memberEmail", memberEmail);
		emailMap.put("encEmail", encEmail);
		
		int result = dao.insertEncEmail(emailMap);
		
		// 데이터 삽입을 성공한 경우
		if(result > 0) {
			
			emailCtrl.sendPwLink(memberEmail, encEmail, req);
			
		}
		
		
		return result;
	}


	// 비밀번호 재설정하기
	@Override
	public int resetPw(String encEmail, String newPw) {
		
		
		int result = 0;
		
		// 암호화된 글자로 회원 이메일 찾기
		String memberEmail = dao.findMemberEmail(encEmail);
		
		if(memberEmail != null) {
			
			Member member = new Member();
			member.setMemberEmail(memberEmail);
			// 비밀번호 암호화 후 세팅
			member.setMemberPw(encoder.encode(newPw));
			
			result = dao.resetPw(member);
			
			if(result > 0) {
				// 비밀번호 변경 성공
				member.setMemberPw(null);
				// 변경 완료하면 해당 이메일의 변경링크를 모두 무효화
				dao.deleteResetLog(memberEmail);
				
			}else {
				System.out.println("비밀번호 변경 실패");
			}
			
		}else {
			
			System.out.println("유효한 링크가 아닙니다.");
		}

		return result;
		
	}

	
	// 이메일 인증번호 삽입하기
	@Override
	@Transactional
	public int insertAuthCode(String memberEmail, String authCode) {

		int result = 0;
		
		MemberAuth memberAuth = new MemberAuth();
		
		memberAuth.setMemberEmail(memberEmail);
		memberAuth.setAuthCode(authCode);
		
		// 해당 이메일의 인증번호 기록을 모두 삭제 후 삽입
		dao.deleteAuthCode(memberEmail);
		
		result = dao.insertAuthCode(memberAuth);
		
		if(result > 0) {
			emailCtrl.sendMail(memberEmail, authCode);
		}
		
		return result;
	}


	// 이메일 인증번호 조회하기
	@Override
	public int selectAuthCode(String memberEmail, String authCode) {

		MemberAuth memberAuth = new MemberAuth();
		
		memberAuth.setMemberEmail(memberEmail);
		memberAuth.setAuthCode(authCode);
		
		int result = dao.selectAuthCode(memberAuth);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
