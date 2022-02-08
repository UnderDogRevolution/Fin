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
public class AdminServiceImpl2 implements AdminService{

	@Autowired
	private AdminDAO dao;

	/** 관리자 로그인
	 *
	 */
	@Override
	public Admin adminLogin(Admin member) {

		
		return dao.adminLogin(member);
	}

	public AdminServiceImpl2(AdminDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Pagination getPagination(int cp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> memberBoard(Pagination pagination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> selectAskList(Pagination pagination) {
		return dao.selectAskList(pagination);
	}
	
	
}
