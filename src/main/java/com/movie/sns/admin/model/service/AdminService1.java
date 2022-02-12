package com.movie.sns.admin.model.service;

import java.util.List;

import com.movie.sns.admin.model.vo.AdminPost;
import com.movie.sns.admin.model.vo.AdminReply;
import com.movie.sns.admin.model.vo.AdminReport;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.admin.model.vo.PostStatus;
import com.movie.sns.admin.model.vo.ReplyStatus;

public interface AdminService1 {

	Pagination getPagination(int cp ,AdminPost post);

	List<AdminPost> adminPost(Pagination pagination, AdminPost post);

	int changeStatus(AdminPost post);

	List<PostStatus> selectStatus();

	AdminPost postView(String postNo);

	Pagination getReplyPagination(int cp, AdminReply reply);

	List<AdminReply> adminReply(Pagination pagination, AdminReply reply);

	List<ReplyStatus> selectReplyStatus();

	int changeStatus(AdminReply reply);

	AdminReply replyView(String replyNo);

	List<AdminReport> reportBoard(AdminReport report);

	
	
	
	
	
}
