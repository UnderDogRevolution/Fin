package com.movie.sns.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	/*	
		*//*************** 회원 정보 로직 ***************//*
														 * 
														 * //첨부파일을 DB에서 불러오기 UserImgsVO getProfile(int userNo) throws
														 * Exception;
														 * 
														 * //프로필 사진 등록 void insertUserImg(UserImgsVO file) throws
														 * Exception;
														 * 
														 * //프로필 사진 삭제 void deleteUserImg(int userNo) throws Exception;
														 */
}
