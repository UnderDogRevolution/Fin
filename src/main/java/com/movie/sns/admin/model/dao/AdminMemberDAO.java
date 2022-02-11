package com.movie.sns.admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.admin.model.vo.AdminMemberSearch;
import com.movie.sns.admin.model.vo.MemberStatus;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;

@Repository
public class AdminMemberDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 전체 회원 수 조회
	 * @return
	 */
	public int getListCount() {
		return sqlSession.selectOne("adminMapper2.getListCount");
	}

	/** 전체 회원 리스트 조회
	 * @param pagination
	 * @return
	 */
	public List<Member> selectMemberList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("adminMapper2.selectMember", null, rowBounds);
	}

	/** 회원 상세 조회
	 * @param memberNo
	 * @return
	 */
	public Member selectMemberDetail(int memberNo) {

		return sqlSession.selectOne("adminMapper2.selectMemberDetail", memberNo);
	}

	/** 회원 상태 조회
	 * @return
	 */
	public List<MemberStatus> selectStatus() {
		return sqlSession.selectList("adminMapper2.selectStatus");
	}

	/** 검색 조건 만족하는 멤버 수
	 * @param search
	 * @return
	 */
	public int getSearchListCount(AdminMemberSearch search) {
		return sqlSession.selectOne("adminMapper2.getSearchListCount");
	}

	/** 검색 조건 만족하는 회원 리스트
	 * @param pagination
	 * @param search
	 * @return
	 */
	public List<Member> selectMemberList(Pagination pagination, AdminMemberSearch search) {

		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		int limit = pagination.getLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlSession.selectList("adminMapper2.selectSearchMemberList", search, rowBounds);
	}

	/** 회원 상태 수정
	 * @param member
	 * @return result
	 */
	public int changeStatus(Member member) {

		return sqlSession.update("adminMapper2.changeStatus", member);
	}

	/** 회원 상태 일괄 변경(정지)
	 * @param checkedMemberNo
	 * @return result 
	 */
	public int multiChangeStatus(int[] checkedMemberNo) {
		return sqlSession.update("adminMapper2.multiChangeStatus", checkedMemberNo);
	}

	/** 회원 상태 일괄 변경 (일반)
	 * @param checkedMemberNo
	 * @return result
	 */
	public int multiChangeStatus2(int[] checkedMemberNo) {
		return sqlSession.update("adminMapper2.multiChangeStatus2", checkedMemberNo);
	}

	/** 회원 상태 일괄 변경 (탈퇴)
	 * @param checkedMemberNo
	 * @return result
	 */
	public int multiChangeStatus3(int[] checkedMemberNo) {
		return sqlSession.update("adminMapper2.multiChangeStatus3", checkedMemberNo);
	}
	
	
}
