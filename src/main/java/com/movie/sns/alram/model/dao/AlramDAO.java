package com.movie.sns.alram.model.dao;


import java.util.List;

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



	public List<Alram> selectAlram(int memberNo) {
		
		return sqlSession.selectList("alramMapper.selectAlram", memberNo);
	}



	public int deleteAlram(int deleteAlramNo) {
		
		return sqlSession.update("alramMapper.deleteAlram", deleteAlramNo);
	}

}
