package com.movie.sns.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.admin.model.vo.Admin;
@Repository
public class AdminDAO1 {
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	/** 관리자 로그인
	 * @param member
	 * @return
	 */
	public Admin adminLogin(Admin member) {
		
		return sqlSession.selectOne("adminMapper.login", member);
	}

}
