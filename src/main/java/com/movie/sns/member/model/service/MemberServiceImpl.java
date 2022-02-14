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
import com.movie.sns.member.model.dao.MemberDAO2;
import com.movie.sns.member.model.vo.Image;
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
	private MemberDAO2 dao2;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	// 이메일 전송용 컨트롤러
	@Autowired
	private EmailController emailCtrl;
	
	
	// 로그인
	@Override
	public Member login(Member member) {
		
		String encPw = encoder.encode(member.getMemberPw());
		
		
		// 로그인 회원의 정보 담기
		Member loginMember = dao.login(member.getMemberEmail());
		
		
		// 로그인에 성공한 경우
		if(loginMember != null && encoder.matches(member.getMemberPw(), loginMember.getMemberPw()) ) {
			
			loginMember.setMemberPw(null);
			
			
			// 로그인 회원 프로필 이미지 담기
			Image loginMemberProfile = dao.selectProfileImage(loginMember.getMemberNo()); 
			
			loginMember.setProfileImage( loginMemberProfile );
			
			
			// 로그인 회원 팔로워, 팔로잉 리스트 담기
			
			
			
		}
		else {
			
			loginMember = null;
			
		}
		
		
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
		
		// 회원 가입 수행 후 memberNo를 반환받아온다. 실패하면 0 반환받아온다.
		int result = dao.signUp(member);
		
		// 회원 가입 성공 시 memberNo를 이용해 기본 프로필 이미지 삽입하기
		if(result > 0) {
			
			Image profileImage = new Image();
			
			// 기본 프로필 이미지 삽입
			profileImage.setImgPath("/resources/images/common/");
			profileImage.setImgName("defaultProfileImage.png"); 
			profileImage.setImgOriginal("defaultProfileImage.png");
			profileImage.setMemberNo(result);
			
			System.out.println("프로필 이미지 정보" + profileImage);
			
			result = dao.insertProfileImage(profileImage);
			
		}
		
		return result;
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
		
		// 수행 전 비밀번호 변경 링크 지우기
		dao.deleteResetLog(memberEmail);
		
		int result = dao.insertEncEmail(emailMap);
		
		// 데이터 삽입을 성공한 경우
		if(result > 0) {
			
			emailCtrl.sendPwLink(memberEmail, encEmail, req);
			
		}
		
		return result;
	}


	// 비밀번호 재설정하기
	@Override
	@Transactional
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
				// 비번 수정 실패
				result = 0;
			}
			
		}else {
			// 유효한 링크가 아닙니다.
			result = -1;
		}

		return result;
		
	}

	
	// 이메일 인증번호 삽입하기
	@Override
	@Transactional
	public int insertAuthCode(String memberEmail, String authCode, HttpServletRequest req) {

		int result = 0;
		
		MemberAuth memberAuth = new MemberAuth();
		
		memberAuth.setMemberEmail(memberEmail);
		memberAuth.setAuthCode(authCode);
		
		// 해당 이메일의 인증번호 기록을 모두 삭제 후 삽입
		dao.deleteAuthCode(memberEmail);
		
		result = dao.insertAuthCode(memberAuth);
		
		if(result > 0) {
			emailCtrl.sendMail(memberEmail, authCode, req);
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
