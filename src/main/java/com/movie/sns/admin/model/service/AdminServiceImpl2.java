package com.movie.sns.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.admin.model.dao.AdminDAO2;
import com.movie.sns.admin.model.vo.AdminAsk;
import com.movie.sns.admin.model.vo.AdminMemberSearch;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.common.Util;

@Service
public class AdminServiceImpl2 implements AdminService2 {

	/** 마이바티스 SQL
	 * 
	 */
	@Autowired
	private AdminDAO2 dao;

	/** 전체 문의글 카운트
	 *
	 */
	@Override
	public Pagination getPagination(int cp) {
		
		int listCount = dao.getListCount();

		return new Pagination(listCount, cp);
	}

	/** 문의글 목록 조회
	 *
	 */
	@Override
	public List<AdminAsk> selectAskList(Pagination pagination) {
		return dao.selectAskList(pagination);
	}

	
	/**문의글 상세 조회
	 *
	 */
	@Override
	public AdminAsk selectAskDetail(int askNo) {
		return dao.selectAskDetail(askNo);
	}

	/**문의글 삭제
	 *
	 */
	@Override
	public int askDelete(int askNo) {
		return dao.askDelete(askNo);
	}

	/** 검색 조건 만족하는 페이지네이션
	 *
	 */
	@Override
	public Pagination getPagination(int cp, AdminMemberSearch search) {
		int searchListCount = dao.getSearchListCount(search);
		
		return new Pagination(searchListCount, cp);
	}

	
	/**검색 조건 만족하는 문의글 리스트
	 *
	 */
	@Override
	public List<AdminAsk> selectAskList(Pagination pagination, AdminMemberSearch search) {
		return dao.selectAskList(pagination,search);
	}
	
	

	
}
