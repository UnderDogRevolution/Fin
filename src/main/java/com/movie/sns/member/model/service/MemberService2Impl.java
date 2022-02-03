package com.movie.sns.member.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

	// 회원 정보 수정
	@Override
	public int updateMember(Member member) {
		return dao.updateMember(member);
	}

	// 프사 수정
	@Override
	public int updateImage(Member member, List<MultipartFile> images, String webPath, String serverPath) {

		
		int memberNo = dao.updateImage(member);

		if(memberNo > 0) { 
			
			List<Image> imgList = new ArrayList<Image>();
			
		for (int i = 0; i < images.size(); i++) {

			if (!images.get(i).getOriginalFilename().equals("")) {

				Image img = new Image();
				img.setImgPath(webPath); // 웹 접근 경로
				img.setImgOriginal(images.get(i).getOriginalFilename()); // 원본 파일명
				img.setImgName(Util.fileRename(images.get(i).getOriginalFilename())); // 변경된 파일명
				img.setImgLevel(i); // 이미지 레벨
				img.setMemberNo(memberNo);

				imgList.add(img);
			}
		}
		
		//파일이 있다면 저장
		if (!imgList.isEmpty()) {
			int result = dao.insertImgList(imgList);
			
			if (result == imgList.size()) { 

				for (int i = 0; i < imgList.size(); i++) {

					try {
						images.get(imgList.get(i).getImgLevel())
								.transferTo(new File(serverPath + "/" + imgList.get(i).getImgName()));

					} catch (Exception e) {
						e.printStackTrace();

					}
				}

			}
		}
		}
		return memberNo;
	}

	/*
	 * //바라는 점
	 * 
	 * @Override public int ask(Member member) {
	 * 
	 * 
	 * //개행문자 처리 member.setMemberContent( Util.XSS( member.getMemberContent() ) );
	 * member.setMemberContent( Util.changeNewLine( member.getMemberContent() ) );
	 * 
	 * 
	 * int memberNo = dao.ask(member); return memberNo; }
	 */

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
}
