package com.movie.sns.member.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

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

	
	/** 이미지 삽입
	 * @param img
	 * @return
	 */
	public int insertImage(Image img) {
		return sqlSession.insert("memberMapper.insertImage", img);
	}

	
	public int updateImage(Image img) {
		return sqlSession.delete("memberMapper.updateImage", img);
	}

	public List<String> selectImgList() {
		return sqlSession.selectList("boardMapper.selectImgList");
	}
	
	/**
	 * 바라는 점 내용 삽입
	 * 
	 * @param member
	 * @return
	 *//*
		 * public int ask(Member member) { return sqlSession.insert("memberMapper.ask",
		 * member); }
		 */

}
