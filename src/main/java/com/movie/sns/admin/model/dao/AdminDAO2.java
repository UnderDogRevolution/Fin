package com.movie.sns.admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.admin.model.vo.AdminAsk;
import com.movie.sns.admin.model.vo.Pagination;
@Repository
public class AdminDAO2 {
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 전체 게시글 수 count
	 * @return listCount
	 */
	public int getListCount() {
		return sqlSession.selectOne("adminMapper3.getListCount");
	}
	
	
	/**  문의글 목록 조회
	 * @param pagination
	 * @return
	 */
	public List<AdminAsk> selectAskList(Pagination pagination) {

		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit() ;
		int limit = pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("adminMapper3.selectAskList", null, rowBounds);
	}


	/** 문의글 상세 조회
	 * @param memberNo
	 * @return
	 */
	public AdminAsk selectAskDetail(int askNo) {
		return sqlSession.selectOne("adminMapper3.selectAskDetail", askNo);
	}



	/*
	 * public int selectAskDetail(AdminAsk ask) { return
	 * sqlSession.selectOne("memberMapper.selectAskDetail", ask); }
	 */


	

}
