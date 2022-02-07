package com.movie.sns.search.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.search.model.vo.Search;

@Repository
public class SearchDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 회원조회
	public List<Search> searchMember(Search search) {
		
		return sqlSession.selectList("searchMapper.searchMember" , search);
	}
	// 팔로우
	public int follow(Map<String,Object> map) {
		return sqlSession.insert("searchMapper.follow" , map);
	}
	// 팔로우취소
	public int cancell(Map<String, Object> map) {
		return sqlSession.delete("searchMapper.cancell" , map);
	}
	
	
	
	
}
