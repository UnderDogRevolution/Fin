package com.movie.sns.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.admin.model.dao.AdminDAO1;
import com.movie.sns.admin.model.vo.AdminPost;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.admin.model.vo.PostStatus;
import com.movie.sns.common.Util;
import com.movie.sns.member.model.vo.Member;





@Service
public class AdminServiceImpl1 implements AdminService1{

	@Autowired
	private AdminDAO1 dao;

	
	
	@Override
	public Pagination getPagination(int cp,AdminPost post) {
		
		int postCount = dao.postCount(cp,post);
			System.out.println("카운트"+postCount);
		return new Pagination(postCount, cp);
	}

	/** 게시글 조회
	 *
	 */
	@Override
	public List<AdminPost> adminPost(Pagination pagination, AdminPost post ) {
		
		return   dao.adminPost(pagination,post);
	}

	@Override
	public int changeStatus(AdminPost post) {
		int result = 0;
		result = dao.changeStatus(post);
		if(post.getStatus() == "502") {
			result = dao.insertBlind(post);
			
		}
			
		//
		return result;
	}

	@Override
	public List<PostStatus> selectStatus() {
		return dao.selectStatus();
	}



	
	
}
