package com.movie.sns.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.admin.model.dao.AdminDAO;
import com.movie.sns.admin.model.vo.Admin;
import com.movie.sns.admin.model.vo.Pagination;
import com.movie.sns.member.model.vo.Member;





/**
 * @author home
 *
 */
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO dao;

	/** 관리자 로그인
	 *
	 */
	@Override
	public Member adminLogin(Member member) {

		
		return dao.adminLogin(member);
	}



	@Override
	public int postCount() {
		return dao.postCount();
	}



	@Override
	public int replyCount() {
		return dao.replyCount();
	}



	@Override
	public int reportCount() {
		return dao.reportCount();
	}



	@Override
	public int askCount() {
		return dao.askCount();
	}



	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return dao.memberCount();
	}
	
	
}
