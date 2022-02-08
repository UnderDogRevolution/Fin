package com.movie.sns.admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;
@Repository
public class AdminDAO2 {
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	/** 관리자 로그인
	 * @param member
	 * @return
	 */
	public Admin adminLogin(Admin member) {
		
		return sqlSession.selectOne("adminMapper.login", member);
	}


	public List<Member> selectAskList(Pagination pagination) {

		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit() ;
		int limit = pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("boardMapper.selectAskList", null, rowBounds);
	}

}
