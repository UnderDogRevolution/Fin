package com.movie.sns.admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.AdminPost;
import com.movie.sns.admin.model.vo.Pagination;
@Repository
public class AdminDAO1 {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int postCount(int cp) {
		return sqlSession.selectOne("adminMapper1.postCount");
	}

	public List<AdminPost> adminPost(Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		int limit = pagination.getLimit(); 
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSession.selectList("adminMapper1.adminPost",null ,rowBounds);
	}
	

}
