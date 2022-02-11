package com.movie.sns.admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.AdminPost;
import com.movie.sns.admin.model.vo.AdminReply;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.admin.model.vo.PostStatus;
import com.movie.sns.admin.model.vo.ReplyStatus;
@Repository
public class AdminDAO1 {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int postCount(int cp ,AdminPost post) {
		return sqlSession.selectOne("adminMapper1.postCount",post);
	}

	public List<AdminPost> adminPost(Pagination pagination, AdminPost post) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		int limit = pagination.getLimit(); 
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSession.selectList("adminMapper1.adminPost",post,rowBounds);
	}

	public int changeStatus(AdminPost post) {
		return sqlSession.update("adminMapper1.changeStatus" , post);
	}

	public int insertBlind(AdminPost post) {
		// TODO Auto-generated method stub
		return sqlSession.insert("adminMapper1.blind" , post);
	}

	public List<PostStatus> selectStatus() {
		return sqlSession.selectList("adminMapper1.selectStatus");
	}

	public AdminPost postView(String postNo) {
		return sqlSession.selectOne("adminMapper1.postView",postNo);
	}

	public PostStatus searchStatus(AdminPost post) {
		return sqlSession.selectOne("adminMapper1.searchStatus", post);
	}

	public int deleteBlind(AdminPost post) {
		return sqlSession.delete("adminMapper1.deleteBlind" , post);
	}

	public int replyCount(int cp, AdminReply reply) {
		return sqlSession.selectOne("adminMapper1.replyCount" , reply);
	}

	public List<AdminReply> adminReply(Pagination pagination, AdminReply reply) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		int limit = pagination.getLimit(); 
		RowBounds rowBounds = new RowBounds(offset, limit);
		return sqlSession.selectList("adminMapper1.adminReply" , reply , rowBounds );
	}

	public List<ReplyStatus> selectReplyStatus() {
		return sqlSession.selectList("adminMapper1.selectReplyStatus");
	}

	public ReplyStatus searchStatus(AdminReply reply) {
		return sqlSession.selectOne("adminMapper1.searchStatusReply", reply);
	}

	public int deleteBlind(AdminReply reply) {
		return sqlSession.delete("adminMapper1.deleteReplyBlind" , reply);
	}

	public int changeStatus(AdminReply reply) {
		return sqlSession.update("adminMapper1.changeReplyStatus", reply);
	}

	public int insertBlind(AdminReply reply) {
		return sqlSession.insert("adminMapper1.insertReplyBlind", reply);
	}

	public AdminReply replyView(String replyNo) {
		return sqlSession.selectOne("adminMapper1.replyView", replyNo);
	}

	
	
	

}
