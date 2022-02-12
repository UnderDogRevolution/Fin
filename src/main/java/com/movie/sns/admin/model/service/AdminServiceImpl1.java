package com.movie.sns.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.admin.model.dao.AdminDAO1;
import com.movie.sns.admin.model.vo.AdminPost;
import com.movie.sns.admin.model.vo.AdminReply;
import com.movie.sns.admin.model.vo.AdminReport;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.admin.model.vo.PostStatus;
import com.movie.sns.admin.model.vo.ReplyStatus;

@Service
public class AdminServiceImpl1 implements AdminService1 {

	@Autowired
	private AdminDAO1 dao;

	// 게시글 페이징
	@Override
	public Pagination getPagination(int cp, AdminPost post) {

		int postCount = dao.postCount(cp, post);
		System.out.println("카운트" + postCount);
		return new Pagination(postCount, cp);
	}

	// 댓글 페이징
	@Override
	public Pagination getReplyPagination(int cp, AdminReply reply) {
		int replyCount = dao.replyCount(cp, reply);
		return new Pagination(replyCount, cp);
	}

	/**
	 * 게시글 조회
	 *
	 */
	@Override
	public List<AdminPost> adminPost(Pagination pagination, AdminPost post) {

		return dao.adminPost(pagination, post);
	}

	@Override
	public int changeStatus(AdminPost post) {
		int result = 0;
		PostStatus searchStatus;
		searchStatus = dao.searchStatus(post);
		System.out.println(searchStatus);
		if (searchStatus.getStatusCd() == 502) {
			result = dao.deleteBlind(post);
			if (result >= 0) {
				result = dao.changeStatus(post);
			}
		} else {

			result = dao.changeStatus(post);
			System.out.println("하..." + result);
			

			if (result > 0) {
				
				searchStatus = dao.searchStatus(post);
				if (searchStatus.getStatusCd() == 502) {
					result = dao.insertBlind(post);
				}

			}
		}

		//
		return result;
	}

	@Override
	public List<PostStatus> selectStatus() {
		return dao.selectStatus();
	}

	@Override
	public AdminPost postView(String postNo) {

		return dao.postView(postNo);
	}

	@Override
	public List<AdminReply> adminReply(Pagination pagination, AdminReply reply) {
		// TODO Auto-generated method stub
		return dao.adminReply(pagination, reply);
	}

	@Override
	public List<ReplyStatus> selectReplyStatus() {
		return dao.selectReplyStatus();
	}

	@Override
	public int changeStatus(AdminReply reply) {

		int result = 0;
		ReplyStatus searchStatus;
		searchStatus = dao.searchStatus(reply);
	if (searchStatus.getStatusCd() == 602) {
 
			result = dao.deleteBlind(reply);
			if (result > 0) {
				result = dao.changeStatus(reply);
			}
		} else {

			result = dao.changeStatus(reply);
			
			if (result > 0) {
				searchStatus = dao.searchStatus(reply);
				System.out.println(searchStatus.getStatusCd());
				if (searchStatus.getStatusCd() == 602) {
					result = dao.insertBlind(reply);
				}

			}
		}

		//
		return result;
	}

	@Override
	public AdminReply replyView(String replyNo) {
		return dao.replyView(replyNo);
	}

	@Override
	public List<AdminReport> reportBoard(AdminReport report) {
		
		return dao.reportBoard(report);
	}


}
