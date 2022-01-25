package com.movie.sns.member.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	/** 이미지 목록 삽입
	 * @param imgList
	 * @return result
	 */
	public int insertImgList(List<Image> imgList) {
		return sqlSession.insert("memberMapper.insertImgList", imgList);
	}
 
	
	/** 기존에 있었지만 삭제된 이미지 DELETE
	 * @param map
	 * @return result
	 */
	public int deleteImages(Map<String, Object> map) {
		return sqlSession.delete("memberMapper.deleteImages", map);
	}

	
	/** 프로필 이미지 수정
	 * @param img
	 * @return result
	 */
	public int updateImage(Image img) {
		return sqlSession.update("memberMapper.updateBoardImage", img);
	}

	
	/** 프로필 이미지 삽입
	 * @param img
	 * @return result
	 */
	public int insertImage(Image img) {
		return sqlSession.insert("memberMapper.insertImage", img);
	}
	
	/** 이미지 파일명 목록 조회
	 * @return dbImgList
	 */ 
	public List<String> selectImgList() {
		return sqlSession.selectList("memberMapper.selectImgList");
	}
}
