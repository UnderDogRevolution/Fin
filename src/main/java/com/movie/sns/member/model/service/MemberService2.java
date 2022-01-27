package com.movie.sns.member.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.movie.sns.member.model.vo.Member;

public interface MemberService2 {

	
	 
	/** 로그인
	 * @param member
	 * @return member
	 */
	Member login(Member member);
	
	/** 회원 정보 수정 + 프로필 사진 수정
	 * @param member
	 * @param images
	 * @param webPath
	 * @param serverPath
	 * @param deleteImages
	 * @return
	 */
	int updateMember(Member member, List<MultipartFile> images, String webPath, String serverPath, String deleteImages);

	
	/** 이미지 파일명 목록 조회
	 * @return dbImgList
	 */
	List<String> selectImgList();
	
	
	/** 비밀번호 변경
	 * @param map
	 * @return result
	 */
	int updatePw(Map<String, String> map);

	/** 회원 탈퇴
	 * @param memberNo
	 * @param currentPw
	 * @return result
	 */
	int secession(int memberNo, String currentPw);

}