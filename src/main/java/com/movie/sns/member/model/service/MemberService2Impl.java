package com.movie.sns.member.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.movie.sns.admin.model.vo.AdminAsk;
import com.movie.sns.common.Util;
import com.movie.sns.member.model.dao.MemberDAO2;
import com.movie.sns.member.model.vo.*;
import com.movie.sns.member.model.vo.Image;

@Service
public class MemberService2Impl implements MemberService2 {

	@Autowired
	private MemberDAO2 dao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	// 비번수정
	@Override
	public int updatePw(Map<String, String> map) {

		String savePw = dao.selectSavePw(map.get("memberNo"));

		int result = 0;
		if (encoder.matches(map.get("currentPw"), savePw)) { // 일치할 때

			String encPw = encoder.encode(map.get("newPw")); // 새 비밀번호 암호화
			map.put("newPw", encPw);

			result = dao.updatePw(map);
		}

		return result;
	}

	// 회원 수정
	@Transactional
	@Override
	public int updateMember(Member member, List<MultipartFile> images, String webPath, String serverPath,
			int deleteCheck) {

		int result = dao.updateMember(member);

			
			if(deleteCheck == 1) { //1일때 기본이미지
				Image img = new Image();
				img.setImgPath("/resources/images/common/");
				img.setImgName("defaultProfileImage.png");
				img.setImgOriginal("defaultProfileImage.png");
				img.setMemberNo(member.getMemberNo());
				System.out.println(img);
				result = dao.updateImage(img);
		if(deleteCheck == 1) { //1일때 기본이미지
				
			
			Image img = new Image();
			img.setImgPath("/resources/images/common/");
			img.setImgName("defaultProfileImage.png");
			img.setImgOriginal("defaultProfileImage.png");
			img.setMemberNo(member.getMemberNo());
			System.out.println(img);
			result = dao.updateImage(img);
			
		}
		
		else {
			List<Image> imgList = new ArrayList<Image>();
			
			for (int i = 0; i < images.size(); i++) {
				if (!images.get(i).getOriginalFilename().equals("")) {
					
					Image img = new Image();
					img.setImgPath(webPath); // 웹 접근 경로
					img.setImgOriginal(images.get(i).getOriginalFilename()); // 원본 파일명
					img.setImgName(Util.fileRename(images.get(i).getOriginalFilename())); // 변경된 파일명
					img.setImgLevel(i); // 이미지 레벨
					img.setMemberNo(member.getMemberNo());
					
					imgList.add(img);
					member.setProfileImage(img);
					
					System.out.println(img);
				}
			}
			
			for (Image img : imgList) {
				
				result = dao.updateImage(img);
			} 
			
			// 파일이 있다면 저장
			if (!imgList.isEmpty()) {
				try {
					for (int i = 0; i < imgList.size(); i++) {
						
						images.get(imgList.get(i).getImgLevel())
						.transferTo(new File(serverPath + "/" + imgList.get(i).getImgName()));
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}

		return result;
	}
	
	
	/** 프로필사진 이미지 리스트
	 *
	 */
	@Override
	public List<String> selectImgList() {
		return dao.selectImgList();
	}
	
	// 회원 이미지 조회
	@Override
	public Image selectProfileImage(int memberNo) {
		return dao.selectProfileImage(memberNo);
	}

	// 회원 탈퇴
	@Override
	public int secession(int memberNo, String currentPw) {

		String savePw = dao.selectSavePw(memberNo + "");
		int result = 0;
		if (encoder.matches(currentPw, savePw)) {
			result = dao.secession(memberNo);
		}
		return result;
	}

	//문의글 삽입
	@Override
	public int insertAsk(AdminAsk ask) {

		//제목, 내용에 개행문자 처리
		ask.setAskTitle(Util.XSS(ask.getAskTitle()));
		ask.setAskContent(Util.XSS(ask.getAskContent()));
		ask.setAskContent(Util.changeNewLine(ask.getAskContent()));
		
		int askNo=dao.insertAsk(ask);
						
		return askNo;
	}
	
	
	
}
