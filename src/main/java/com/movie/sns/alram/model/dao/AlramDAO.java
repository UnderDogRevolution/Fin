package com.movie.sns.alram.model.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.alram.model.vo.Alram;

@Repository
public class AlramDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	

	public int insertAlram(Alram alram) {
		
		
		
		return sqlSession.insert("alramMapper.insertAlram", alram);
	}

}
