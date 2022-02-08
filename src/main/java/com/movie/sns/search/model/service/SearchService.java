package com.movie.sns.search.model.service;

import java.util.List;
import java.util.Map;

import com.movie.sns.search.model.vo.Search;

public interface SearchService {
	// 회원검색
	List<Search> searchMember(Search search);
	// 팔로우
	int follow(Map<String,Object> map);
	// 팔로우 취소
	int cancell(Map<String,Object> map);

}
