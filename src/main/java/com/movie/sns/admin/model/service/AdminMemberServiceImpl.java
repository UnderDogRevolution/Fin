package com.movie.sns.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.admin.model.dao.AdminMemberDAO;

@Service
public class AdminMemberServiceImpl implements AdminMemberService{

	
	@Autowired
	private AdminMemberDAO dao;
	
	
	
	
}
