package com.movie.sns.admin.model.service;

import java.util.List;

import com.movie.sns.admin.model.vo.AdminPost;
import com.movie.sns.admin.model.vo.Pagination;

public interface AdminService1 {

	Pagination getPagination(int cp);

	List<AdminPost> adminPost(Pagination pagination);
	
	
	
	
	
}