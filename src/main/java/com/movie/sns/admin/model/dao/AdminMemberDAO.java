package com.movie.sns.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminMemberDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
}
