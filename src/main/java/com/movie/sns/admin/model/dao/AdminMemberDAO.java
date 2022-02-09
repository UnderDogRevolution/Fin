package com.movie.sns.admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;

@Repository
public class AdminMemberDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int getListCount() {
		return sqlSession.selectOne("adminMapper2.getListCount");
	}

	public List<Member> selectMemberList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("adminMapper2.selectMember", null, rowBounds);
	}

	public Member selectMemberDetail(int memberNo) {

		return sqlSession.selectOne("adminMapper2.selectMemberDetail", memberNo);
	}
	
	
}
