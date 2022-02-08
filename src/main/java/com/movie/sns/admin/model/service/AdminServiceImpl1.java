package com.movie.sns.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.admin.model.dao.AdminDAO1;
import com.movie.sns.admin.model.vo.AdminPost;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.common.Util;
import com.movie.sns.member.model.vo.Member;





@Service
public class AdminServiceImpl1 implements AdminService1{

	@Autowired
	private AdminDAO1 dao;

	
	
	@Override
	public Pagination getPagination(int cp) {
		
		int postCount = dao.postCount(cp);
		
		return new Pagination(postCount, cp);
	}

	/** 게시글 조회
	 *
	 */
	@Override
	public List<AdminPost> adminPost(Pagination pagination ) {
		

		List<AdminPost> post =  dao.adminPost(pagination);
		
		
				
		
		return post;
	}



	
	
}
