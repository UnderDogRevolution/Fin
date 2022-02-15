package com.movie.sns.member.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.movie.sns.admin.model.vo.AdminAsk;
import com.movie.sns.member.model.vo.Image;
import com.movie.sns.member.model.vo.Member;

@Repository
public class MemberDAO2 {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 회원 정보 수정
	 * 
	 * @param member
	 * @return result
	 */
	public int updateMember(Member member) {
		return sqlSession.update("memberMapper.updateMember", member);
	}

	/**
	 * 현재 DB에 저장된 암호화된 비밀번호 조회
	 * 
	 * @param memberNo
	 * @return savePw
	 */
	public String selectSavePw(String memberNo) {
		return sqlSession.selectOne("memberMapper.selectSavePw", memberNo);
	}

	/**
	 * 비밀번호 변경
	 * 
	 * @param map
	 * @return result
	 */
	public int updatePw(Map<String, String> map) {
		return sqlSession.update("memberMapper.updatePw", map);
	}

	/**
	 * 회원 탈퇴
	 * 
	 * @param memberNo
	 * @return result
	 */
	public int secession(int memberNo) {
		return sqlSession.update("memberMapper.secession", memberNo);
	}

	/** 이미지 삭제
	 * @param map
	 * @return
	 */
	public int deleteImages(Map<String, Object> map) {
		return sqlSession.delete("memberMapper.deleteImages", map);
	}

	/** 이미지 수정
	 * @param img
	 * @return
	 */
	public int updateImage(Image img) {
		return sqlSession.delete("memberMapper.updateImage", img);
	}

	/** 이미지 정보리스트
	 * @return
	 */
	public List<String> selectImgList() {
		return sqlSession.selectList("memberMapper.selectImgList");
	}

	
	/** 문의글 삽입
	 * @param ask
	 * @return
	 */
	public int insertAsk(AdminAsk ask) {
		return sqlSession.insert("memberMapper.insertAsk", ask);
	}

	/** 회원 이미지 조회
	 * @param memberNo
	 * @return image
	 */
	public Image selectProfileImage(int memberNo) {
		return sqlSession.selectOne("memberMapper2.selectProfileImage", memberNo);
	}

}
