package com.movie.sns.search.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.search.model.dao.SearchDAO;
import com.movie.sns.search.model.vo.Search;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchDAO dao;

	@Override
	public List<Search> searchMember(Search search) {
		
		return dao.searchMember(search);
	}

	// 팔로우
	@Override
	public int follow(Map<String,Object> map) {

		
		return dao.follow(map);
	}
	
	// 팔로우 취소
	@Override
	public int cancell(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return dao.cancell(map);
	}
	
	
	
}
