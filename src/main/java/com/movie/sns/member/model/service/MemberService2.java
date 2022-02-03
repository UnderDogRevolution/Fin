package com.movie.sns.member.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.movie.sns.member.model.vo.Member;

public interface MemberService2 {

	/**
	 * 회원 정보 수정
	 * 
	 * @param member
	 * @return
	 */
	int updateMember(Member member);

	/**
	 * 프로필 사진 수정
	 * 
	 * @param member
	 * @param serverPath
	 * @param webPath
	 * @param images
	 * @param images
	 * @param webPath
	 * @param serverPath
	 * @param deleteImages
	 * @return
	 */
	int updateImage(Member member, List<MultipartFile> images, String webPath, String serverPath);

	/**
	 * 비밀번호 변경
	 * 
	 * @param map
	 * @return result
	 */
	int updatePw(Map<String, String> map);

	/**
	 * 회원 탈퇴
	 * 
	 * @param memberNo
	 * @param currentPw
	 * @return result
	 */
	int secession(int memberNo, String currentPw);

	/*	*//**
			 * 바라는 점
			 * 
			 * @param member
			 * @return
			 *//*
				 * int ask(Member member);
				 */

}