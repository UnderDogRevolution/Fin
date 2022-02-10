package com.movie.sns.admin.model.service;

import java.util.List;

import com.movie.sns.admin.model.vo.AdminAsk;
import com.movie.sns.admin.model.vo.Pagination;

public interface AdminService2 {

	/** 문의글 카운트+ 페이징 처리
	 * @param cp
	 * @return
	 */
	Pagination getPagination(int cp);

	
	
	/** 문의글 목록 조회
	 * @param pagination
	 * @return
	 */
	List<AdminAsk> selectAskList(Pagination pagination);

	
	
	/** 문의글 상세 조회 모달
	 * @param memberNo
	 * @return
	 */
	AdminAsk selectAskDetail(int askNo);
	
}
