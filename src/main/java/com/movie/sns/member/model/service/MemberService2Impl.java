package com.movie.sns.member.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
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

	// 회원 수정
	@Override
	public int updateMember(Member member, List<MultipartFile> images, String webPath, String serverPath,
			String deleteImages) {

		int result = dao.updateMember(member);

		if (result > 0) {
			if (!deleteImages.equals("")) { // 이미지 삭제일 때
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("MemberNo", member.getMemberNo());
				map.put("deleteImages", deleteImages);

				result = dao.deleteImages(map);
			}
		}

		if (result > 0) {

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
				}
			}

			for (Image img : imgList) {

				// 서로 다른 행을 일괄적으로 update 하는 방법이 없기에
				// 한 행씩 수정
				result = dao.updateImage(img);
				// 결과 1 -> 기존에 저장된 이미지가 수정됨.
				// 결과 0 -> 기존에 저장되지 않은 이미지가 추가됨 -> INSERT 진행

				if (result == 0) { // 기존에 저장되지 않은 이미지가 추가됨 -> INSERT 진행
					result = dao.insertImage(img);
				}

			} // for end

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
	
	
	@Override
	public List<String> selectImgList() {
		return dao.selectImgList();
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
