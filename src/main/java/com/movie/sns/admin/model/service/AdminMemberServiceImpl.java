package com.movie.sns.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.admin.model.dao.AdminMemberDAO;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;

@Service
public class AdminMemberServiceImpl implements AdminMemberService{

	
	@Autowired
	private AdminMemberDAO dao;

	
	@Override
	public Pagination getPagination(int cp) {
		
		int listCount = dao.getListCount(); 
		
		return null;
	}


	
	
	
}
